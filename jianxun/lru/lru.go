package main

type Node struct {
	key   interface{}
	value interface{}
	next  *Node
}

type SimpleLRU struct {
	size  int
	first *Node
	last  *Node
}

func (s *SimpleLRU) set(key interface{}, value interface{}) {

}

func (s *SimpleLRU) get(key interface{}) interface{} {
	return nil
}

func main() {

}
