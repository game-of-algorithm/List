package main

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

}
