package main

import "fmt"

type Node struct {
	key   string
	value interface{}
	prev  *Node
	next  *Node
}

type SimpleLRU struct {
	size        int
	currentSize int
	head        *Node
	tail        *Node
}

// 将新set的节点放在链表的第一个，如果大于缓存大小size将链表的最后一个剔除
func (s *SimpleLRU) Set(key string, value interface{}) {
	node := &Node{key: key, value: value, prev: nil, next: nil}
	if s.currentSize == 0 {
		s.head = node
		s.tail = node
		s.currentSize++
		return
	}
	s.head.prev = node
	node.next = s.head
	s.head = node
	nextCurrentSize := s.currentSize + 1
	// 判断是否大于缓存总大小size, 剔除最后一个
	if nextCurrentSize > s.size {
		s.tail.prev.next = nil
		s.tail = s.tail.prev
		s.currentSize = s.size
		return
	}
	s.currentSize = nextCurrentSize
}

// 将get的节点移动到链表的head位置
func (s *SimpleLRU) Get(key string) interface{} {
	if s.currentSize <= 0 {
		return nil
	}
	var currentNode *Node
	for node := s.head; node.next != nil; node = node.next {
		if node.key == key {
			currentNode = node
			break
		}
	}
	if currentNode != nil {
		// 移位
		// 如果是head, 不移动
		if s.head != currentNode {
			s.head.prev = currentNode
			// 如果是tail 不需要修改tail的next节点
			currentNode.prev.next = currentNode.next
			if s.tail != currentNode {
				currentNode.next.prev = currentNode.prev
			} else {
				s.tail = currentNode.prev
			}
			s.head = currentNode
		}

		return currentNode.value
	}
	return nil
}

func main() {
	lru := &SimpleLRU{size: 3, currentSize: 0, head: nil, tail: nil}
	lru.Set("a", "a")
	lru.Set("b", "b")
	lru.Set("c", "c")
	fmt.Println("head: ", lru.head, "tail: ", lru.tail, "size: ", lru.currentSize)
	lru.Set("d", "d")
	fmt.Println("head: ", lru.head, "tail: ", lru.tail, "size: ", lru.currentSize)
	lru.Get("c")
	fmt.Println("head: ", lru.head, "tail: ", lru.tail, "size: ", lru.currentSize)
}
