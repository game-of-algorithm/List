//package fliplist
package main
import (
	"testing"
)

func TestFliplist (t *testing.T) {
	//1->2->3->4->5->NULL
	a5 := ListNode{5, nil}
	a4 := ListNode{4, &a5}
	a3 := ListNode{3, &a4}
	a2 := ListNode{2, &a3}
	a1 := ListNode{1, &a2}
	ret := reverseList(&a1)
	t.Log("wagaaaaa", ret.Val)
}