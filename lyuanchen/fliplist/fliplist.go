//package
package main
type ListNode struct {
	Val  int
	Next *ListNode
}

func reverseList(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}
	return reverseList(head.Next)
}

func main() {
	a5 := ListNode{5, nil}
	a4 := ListNode{4, &a5}
	a3 := ListNode{3, &a4}
	a2 := ListNode{2, &a3}
	a1 := ListNode{1, &a2}
	ret := reverseList(&a1)
	println(ret.Val)
}