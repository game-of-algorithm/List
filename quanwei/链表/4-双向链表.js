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
    let current = null
    let previous = null
    let i = 0
    if (index === 0) { // 在第一个位置添加
      if (!this.head) {
        this.head = node
        this.tail = node // 只有头的话  可以不要尾
      } else {
        current = this.head
        node.next = current
        current.prev = node
        this.head = node
      }
    } else if (index === this.length) { // 最后一项
      // 如果是末尾，新节点=末尾，新节点的prev是之前的末尾
      current = this.tail
      current.next = node
      node.prev = current
      this.tail = node
    } else { // 在中间
      current = this.head
      while (i++ < index) {
        previous = current
        current = current.next
      }
      // 新节点的prev节点是previous
      // 上一个节点（previous）的next节点是新元素
      node.prev = previous
      previous.next = node
      // 新节点的next节点是定位节点
      // 定位节点的prev节点是新节点
      node.next = current
      current.prev = node
    }
    this.length++
    return true
  }
}

const listNode = new LinkList()
listNode.insert(0, 1)
listNode.insert(1, 2)
listNode.insert(2, 3)
listNode.insert(1, 8)
// console.log(`长度${listNode.length},`, '头部：')
// console.log(listNode.head)
//
// console.log('-----------------------------')
//
// console.log(`长度${listNode.length},`, '尾巴：')
// console.log(listNode.tail)
