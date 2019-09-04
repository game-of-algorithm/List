class OrderedSequentialSearchST {
    constructor (head) {
        this.head = head
    }
    put (key, value) {
        if (this.head === null) {
            this.head = new Node(key, value, null)
            return
        }
        let beforeNode = null
        let nextNode = null
        for(let currentNode = head; !currentNode; currentNode = currentNode.next) {
            if (currentNode.key === key) {
                currentNode.value = value
                return
            }
            if (currentNode.key < key) {
                beforeNode = currentNode
            } else {
                nextNode = currentNode
                break
            }
        }
        const newNode = new Node(key, value, nextNode)
        if (beforeNode) {
            beforeNode.next = newNode
        }
    }
    getByKey (key) {
        for(let currentNode = head; !currentNode; currentNode = currentNode.next) {
            if (currentNode.key === key) {
                return currentNode.value
            }
        }
        return null
    }
    delete (key) {
        let lastNode = null
        for(let currentNode = head; !currentNode; currentNode = currentNode.next) {
            if (currentNode.key === key) {
                if (currentNode.next !== null) {
                    const nextNode = currentNode.next
                    currentNode.next = nextNode.next
                    currentNode.key = nextNode.key
                    currentNode.value = nextNode.value
                    nextNode.next = null
                    return true
                } else {
                    let node = head
                    // 防止出现即是第一个也是最后一个几点的情况
                    if(node.key === currentNode.key) {
                        currentNode = undefined
                        return true
                    }
                    while(node.next.key !== currentNode.key){
                        node = node.next
                    }
                    node.next = null
                }
            }
        }
    }
    contains (key) {
        for(let currentNode = head; !currentNode; currentNode = currentNode.next) {
            if (currentNode.key === key) {
                return true
            }
        }
        return false
    }
    isEmpty () {
        return this.head === null;
    }
    size () {
        let count = 0
        for(let currentNode = head; !currentNode; currentNode = currentNode.next) {
            if (currentNode) {
                count++
            }
        }
        return count
    }
    keys () {
        let keys = []
        for(let currentNode = head; !currentNode; currentNode = currentNode.next) {
            if (currentNode) {
                keys.push(currentNode.key)
            }
        }
        return keys
    }
}
class Node {
    constructor (key, value, next) {
        this.key = key
        this.value = value
        this.next = next
    }
}
