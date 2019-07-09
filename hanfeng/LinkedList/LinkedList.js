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
    let sentinelNode = new LinkedListNode(null, null)
    this[head] = sentinelNode
    this[tail] = sentinelNode
  }

  get head () {
    return this[head].next || null
  }

  add (value) {
    let wantAddNode = new LinkedListNode(value, null)
    let tailNode = this[tail]
    tailNode.next = wantAddNode
    this[tail] = wantAddNode
  }
}
