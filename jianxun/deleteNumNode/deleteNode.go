package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

func removeNthFromEnd(head *ListNode, n int) *ListNode {
	length := 0
	zeroNode := &ListNode{Val: 0}
	zeroNode.Next = head
	first := head
	for first != nil {
		length += 1
		first = first.Next
	}
	length = length - n
	first = zeroNode
	for length > 0 {
		length -= 1
		first = first.Next
	}
	first.Next = first.Next.Next
	return zeroNode.Next
}

func main() {
	a := &ListNode{0, nil}
	for i := 1; i <= 10; i += 1 {
		t := &ListNode{i, nil}
		t.Next = a
		a = t
	}
	res := removeNthFromEnd(a, 4)
	for h := res; h.Next != nil; h = h.Next {
		fmt.Println(h.Val)
	}
}
