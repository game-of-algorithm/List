package main

import (
	"errors"
	"fmt"
)

type Node struct {
	item interface{}
	next *Node
}

type Stack struct {
	first *Node
	size  int
}

func (s *Stack) IsEmpty() bool {
	return s.size == 0
}

func (s *Stack) Push(node *Node) {
	if s.first == nil {
		s.first = node
		s.size = 1
	} else {
		node.next = s.first
		s.first = node
		s.size++
	}
}

func (s *Stack) Pop() (interface{}, error) {
	if s.IsEmpty() {
		return nil, errors.New("Stack is empty")
	}
	item := s.first.item
	s.first = s.first.next
	s.size--
	return item, nil
}

func (s *Stack) Size() int {
	return s.size
}

func main() {
	stack := &Stack{first: nil, size: 0}
	a := &Node{item: "a"}
	b := &Node{item: "b"}
	c := &Node{item: "c"}
	d := &Node{item: "d"}
	fmt.Println("is empty: ", stack.IsEmpty())
	stack.Push(a)
	fmt.Println("size: ", stack.Size())
	stack.Push(b)
	fmt.Println("size: ", stack.Size())
	stack.Push(c)
	fmt.Println("size: ", stack.Size())
	stack.Push(d)
	fmt.Println("size: ", stack.Size())
	item, _ := stack.Pop()
	fmt.Println("size: ", stack.Size(), item)
}
