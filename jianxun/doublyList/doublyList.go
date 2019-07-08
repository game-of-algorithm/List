package main

import (
	"errors"
	"fmt"
)

type Data struct {
	data interface{}
	prev *Data
	next *Data
}

type List struct {
	size int   // 一共多少个节点
	head *Data // 头部数据域指针
	tail *Data // 尾部数据域指针
}

// 尾部追加
func (list *List) Append(data *Data) bool {
	if data == nil {
		return false
	}
	data.next = nil // 链最后data的next为nil，避免环形链

	if list.size == 0 { // 如果是链表的第一个元素
		data.prev = nil
		list.head = data
	} else {
		data.prev = list.tail // 不是第一个元素
		list.tail.next = data
	}
	list.tail = data
	list.size++
	return true
}

// 头部添加
func (list *List) UnShift(data *Data) bool {
	if data == nil {
		return false
	}
	data.prev = nil     // 链头data的prev为nil，避免环形链
	if list.size == 0 { // 如果只有一个节点，头部和尾部相等
		list.tail = data
		data.next = nil
	} else {
		data.next = list.head
		list.head.prev = data
	}
	list.head = data
	list.size++
	return true
}

func (list *List) Size() int {
	return list.size
}

// 获取指定序号的节点
func (list *List) Get(index int) (*Data, error) {
	if index > list.size {
		return nil, errors.New("out of range error")
	}
	if list.size == 0 {
		return nil, nil
	}
	if index == list.size-1 {
		return list.tail, nil
	}
	data := list.head
	for i := 0; i < index; i += 1 {
		data = data.next
	}
	return data, nil
}

// 删除指定序号的节点
func (list *List) Remove(index int) error {
	if index > list.size {
		return errors.New("out of range error")
	}
	if list.size == 0 {
		return errors.New("list is empty")
	}
	// 先获取序号对应的data
	data, err := list.Get(index)
	if err != nil {
		return err
	}
	// 如果有前置节点 前置节点的next先置空断开引用
	if data.prev != nil {
		data.prev.next = data.next
	}
	// 如果有后置节点
	if data.next != nil {
		data.next.prev = data.prev
	}
	list.size--
	return nil
}

func NewDoublyList() *List {
	return &List{size: 0, head: nil, tail: nil}
}

func main() {
	list := NewDoublyList()
	b := list.Append(&Data{data: "b"})
	c := list.Append(&Data{data: "c"})
	a := list.UnShift(&Data{data: "a"})
	fmt.Println("a: ", a, "b: ", b, "c: ", c)
	fmt.Println("list size: ", list.Size())
	d, _ := list.Get(1)
	fmt.Println("get data: ", d.data)
	_ = list.Remove(0)
	fmt.Println("list delete size: ", list.Size())

}
