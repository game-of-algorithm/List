package main

import "fmt"

/**
给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。

k 是一个正整数，它的值小于或等于链表的长度。

如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。

示例 :

给定这个链表：1->2->3->4->5

当 k = 2 时，应当返回: 2->1->4->3->5

当 k = 3 时，应当返回: 3->2->1->4->5

说明 :

你的算法只能使用常数的额外空间。
你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
*/
type ListNode struct {
	Val  int
	Next *ListNode
}

func reverseKGroup(head *ListNode, k int) *ListNode {
	count := 0
	temp := head

	for temp != nil && count != k {
		temp = temp.Next
		count++
	}
	if count == k {
		temp = reverseKGroup(temp, k)
		for count != 0 {
			count--
			p := head.Next
			head.Next = temp
			temp = head
			head = p
		}
		head = temp
	}
	return head
}

func main() {
	a := &ListNode{0, nil}
	for i := 1; i <= 10; i += 1 {
		t := &ListNode{i, nil}
		t.Next = a
		a = t
	}
	res := reverseKGroup(a, 4)
	for h := res; h.Next != nil; h = h.Next {
		fmt.Println(h.Val)
	}
}
