// const _ = require('lodash')

class LinkList {
  constructor () {
    this.length = 0
    this.head = null
  }
  createNode (element) {
    return {
      element,
      next: null
    }
  }
  append (element) {
    const node = this.createNode(element)
    let current = null
    if (this.head === null) this.head = node
    else {
      current = this.head
      while (current.next) {
        current = current.next
      }
      // 尾部的next是 链表头
      node.next = this.head
      current.next = node
    }
    this.length++
  }
  removeAt (index) {
    // 检查越界值
    if (index < 0 || index >= this.length) return null
    let current = this.head
    let i = 0
    let previous = null
    if (index === 0) this.head = current.next
    else {
      while (i++ < index) {
        previous = current
        current = current.next
      }
      // 将上一节点的next 与 选中节点的next链接：跳过current，从而移除它
      previous.next = current.next
    }
    this.length--
    return current.element
  }
}

const listNode = new LinkList()
// listNode.append(1)
// listNode.append(2)
// console.log(`长度：${listNode.length}`, listNode.head)
// console.log(`移除第一个节点，值：${listNode.removeAt(0)}`)
// console.log(`长度：${listNode.length}`, listNode.head)
