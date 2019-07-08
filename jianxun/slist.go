package main

import "fmt"

// 默认为 单项链表的 第一个节点
type Data interface{}

type Node struct {
	Data Data  // 数据域
	Next *Node // 指针域，指向下一个节点
}

func (head *Node) HasNext() bool {
	return head.Next != nil
}

//func (head *Node) Last () *Node {
//	current := head
//	for current.HasNext() {
//		current = current.Next
//	}
//	return current
//}

// 尾部追加
func (head *Node) Append(data Data) *Node {
	last := head
	for last.HasNext() {
		last = last.Next
	}
	last.Next = &Node{Data: data}
	return head
}

// 头部添加
func (head *Node) Unshift(data Data) *Node {
	first := &Node{Data: data}
	first.Next = head
	return first
}

func (head *Node) Length() int {
	length := 1
	for current := head; current.HasNext(); current = current.Next {
		length++
	}
	return length
}

// 还有些bug
func main() {
	sList := &Node{Data: "1"}
	second := &Node{Data: "2"}
	third := &Node{Data: "3"}
	first := &Node{Data: "0"}
	result := sList.Append(second).Append(third).Unshift(first)
	fmt.Println(result.Length())
	for result.HasNext() {
		fmt.Println("data is: ", result.Data)
		result = result.Next
	}
}
