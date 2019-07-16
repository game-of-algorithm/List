package main
import "fmt"

type ListNode struct {
	Val int
	Next *ListNode
}
//https://blog.csdn.net/weixin_42719927/article/details/90083999
func reverseKGroup(head *ListNode, k int) *ListNode {
	var pre, next *ListNode
	var cur, p  = head, head
	groupSize, index := 0, 0
	for p != nil && groupSize < k {
		p = p.Next
		groupSize++
	}
	for cur != nil && index < k {
		next = cur.Next
		cur.Next = pre
		pre = cur
		cur = next
		index++
	}
	if next != nil {
		head.Next = reverseKGroup(next, k)
	}
	return pre
}

func main() {
	a := []int{1, 2, 3, 4, 5}
	l := &ListNode {a[0], nil}
	p := l
	for _, r := range a[1:] {
		node := &ListNode {r, nil}
		p.Next = node
		p = p.Next
	}
	k := 3
	res := reverseKGroup(l, k)
	for res != nil {
		if res.Next != nil {
			fmt.Printf("%d->", res.Val)
		} else {
			fmt.Printf("%d", res.Val)
		}
		res = res.Next
	}
}