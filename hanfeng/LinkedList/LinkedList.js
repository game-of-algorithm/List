const head = Symbol("head")
const tail = Symbol("tail")


class LinkedListNode {
  constructor (value) {
    this.value = value
    this.next = null
  }
}

export default class LinkedList {
  constructor () {
    const sentinelNode = new LinkedListNode(null)
    this[head] = sentinelNode
    this[tail] = sentinelNode
  }

  get head () {
    return this[head].next || null
  }

  get tail () {
    return this[head].next === null ? null : this[tail]
  }

  add (value) {
    let wantAddNode = new LinkedListNode(value, null)
    let tailNode = this[tail]
    tailNode.next = wantAddNode
    this[tail] = wantAddNode
  }

  static reversal (linkedList) {
    let linkedListValues = []
    let tempLinkedListNode = linkedList.head
    while (tempLinkedListNode !== null) {
      linkedListValues.push(tempLinkedListNode.value)
      tempLinkedListNode = tempLinkedListNode.next
    }

    let reversalLinkedList = new LinkedList()
    if (linkedListValues.length === 0) {
      return reversalLinkedList
    }

    for (let i = linkedListValues.length - 1; i >= 0; i--) {
      reversalLinkedList.add(linkedListValues[i])
    }
    return reversalLinkedList
  }
}
