// const _ = require('lodash')

class LinkList {
  constructor () {
    this.length = 0
    // 头
    this.head = null
    // 尾
    this.tail = null
  }
  createNode (element) {
    return {
      element,
      prev: null,
      next: null
    }
  }
  insert (index, element) {
    // 检查越界值
    if (index < 0 || index > this.length) return false
    const node = this.createNode(element)
    let current = this.head
    let previous = null
    let i = 0
    if (index === 0) { // 在第一个位置添加
      if (!this.head) {
        this.head = node
        this.tail = node
      } else {
        node.next = current
        current.prev = node
        this.head = node
      }
    } else if (index === this.length) { // 最后一项
      current = this.tail
      current.next = node
      node.prev = current
      this.tail = node
    } else { // 在中间
      while (i++ < index) {
        previous = current
        current = current.next
      }
      node.next = current
      previous.next = node
      current.prev = node
      node.prev = previous
    }
    this.length++
    return true
  }
}

// const listNode = new LinkList()
// listNode.insert(0, 1)
// listNode.insert(1, 2)
// console.log(`长度${listNode.length},`, '头部：')
// console.log(listNode.head)
//
// console.log('-----------------------------')
//
// console.log(`长度${listNode.length},`, '尾巴：')
// console.log(listNode.tail)
