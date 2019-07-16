const head = Symbol("head")
const tail = Symbol("tail")

const swap = (a, b) => {
  let tmp = a.value
  a.value = b.value
  b.value = tmp
}
const quickSort = (head, end) => {
  if (head === end || head.next === end) return
  let pivot = head.value
  let slow = head
  let fast = head.next
  while (fast !== end) {
    if (fast.value <= pivot) {
      slow = slow.next
      swap(slow, fast)
    }
    fast = fast.next
  }
  swap(head, slow)
  quickSort(head, slow)
  quickSort(slow.next, end)
}

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

  addToTail (value) {
    let wantAddNode = new LinkedListNode(value, null)
    let tailNode = this[tail]
    tailNode.next = wantAddNode
    this[tail] = wantAddNode
  }

  quickSort() {
    quickSort(this[head].next, null)
  }

  reversal () {
    let preNode = null
    let currentNode = this[head].next
    this[tail] = currentNode || this[head]
    while (currentNode !== null) {
      let nextNode = currentNode.next
      currentNode.next = preNode
      preNode = currentNode
      currentNode = nextNode
    }
    this[head].next = preNode
  }

  removeNthFromEnd (n) {
    let p = this[head]
    let q = this[head]

    let moveNextTime = 0
    while(moveNextTime !== n) {
      moveNextTime++
      p = p.next
      if (p === null) {
        return
      }
    }

    while(p.next !== null) {
      p = p.next
      q = q.next
    }
    q.next = q.next.next
    this[tail] = q.next === null ? q : p
  }
}
