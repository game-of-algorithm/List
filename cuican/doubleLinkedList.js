class DoubleLinkedList {
    constructor() {
        this.head = null
        this.size = 0
    }
    add (index, value) {
        if (index < 0 || (!value && value !== 0)) {
            return false
        }
        const currentSize = this.size
        this.size += 1
        if (currentSize === 0 || !this.head) {
            this.head = new Node(value)
            return true
        }
        if (index === 0) {
            const newNode = new Node(value, null, this.head)
            this.head.preNode = newNode
            this.head = newNode
            return true
        }
        if (index >= currentSize) {
            const currentNode = this.getNode(currentSize - 1)
            currentNode.nextNode = new Node(value, currentNode, null)
            return true
        }
        const currentNode = this.getNode(index)
        const newNode = new Node(value, currentNode.preNode, currentNode)
        currentNode.preNode.nextNode = newNode
        currentNode.preNode = newNode
        return true
    }
    remove (index) {
        if (index < 0 || this.size === 0 || !this.head) {
            return false
        }
        const currentSize = this.size
        this.size -= 1
        if (index === 0) {
            if (this.head.nextNode) {
                this.head.nextNode.preNode = null
            }
            this.head = this.head.nextNode
            return true
        }
        if (index >= currentSize) {
            const currentNode = this.getNode(currentSize - 1)
            currentNode.preNode.nextNode = null
            return true
        }
        let currentNode = this.getNode(index)
        currentNode.preNode.nextNode = currentNode.nextNode
        currentNode.nextNode.preNode = currentNode.preNode
        currentNode = null
        return true
    }
    getNode (index) {
        let i = 0
        let currentNode = this.head
        while ( i < index) {
            currentNode = currentNode.nextNode
            i++
        }
        return currentNode
    }
}
class Node {
    constructor (value, preNode, nextNode) {
        this.value = value
        this.preNode = preNode
        this.nextNode = nextNode
    }
}
const list = new DoubleLinkedList()
list.add(0, 1)
list.add(1, 2)
list.add(1, 3)
list.add(1, 4)
list.add(2, 9)
list.add(2, 8)
list.add(3, 7)
list.add(0, 0)
list.remove(0)
list.remove(2)
list.remove(1)
list.add(1, 4)
list.remove(8)
list.remove(5)
let i = 0
let head = list.head
console.log(head.value)
while (i < list.size - 1) {
    head = head.nextNode
    console.log(head.value)
    i++
}
