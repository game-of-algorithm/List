// last recently used
import DoubleLinkedList from './DoubleLinkedList'
export default class LRUCache {
    constructor (maxLength) {
        this.list = new DoubleLinkedList()
        this.maxLength = maxLength
    }
    add (value) {
        if (this.list.size >= this.maxLength) {
            this.list.removeTail()
        }
        this.list.addHead(value)
    }
    get (id) {
        let node = this.list.head
        const targetId = node.value.id
        if (targetId === id) {
            return node.value
        }
        let i = 0
        while (node && id !== node.value.id) {
            node = node.nextNode
            i++
        }
        if (!node) {
            return null
        }
        this.list.removeNode(node)
        this.list.addHead(node.value)
        return node.value
    }

}
