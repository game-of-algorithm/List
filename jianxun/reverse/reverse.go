package main

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */

type ListNode struct {
	Val  int
	Next *ListNode
}

// 利用递归会将所有节点打平，从底层网上层 运行的特点来做
func reverseList(head *ListNode) *ListNode {
	// 没有元素和只有一个元素的时候
	if head == nil || head.Next == nil {
		return head
	}
	node := reverseList(head.Next)
	head.Next.Next = head
	head.Next = nil
	return node
}

func main() {

}
