class Node {
  constructor(element) {
    this.element = element
    this.next = null
  }
}

class LinkedList {
  constructor() {
    this.header = null
    this.length = 0
  }
  addTail(value) {
    const node = new Node(value)
    let current = this.header
    if (this.header === null) {
      this.header = node
    } else {
      while (current.next) {
        current = current.next
      }
      current.next = node
    }
    this.length++
  }
  addHeader(value) {
    const node = new Node(value)
    let current = this.header
    if (this.header === null) {
      this.header = node
    } else {
      node.next = current
      this.header = node
    }
    this.length++
  }
  size() {
    return this.length
  }
  toString() {
    let str = 'header -> '
    if (this.header === null) {
      return '暂无元素'
    } else {
      let current = this.header
      while (current) {
        str += `[ ${current.element} | - ] -> `
        current = current.next
      }
      return str + 'null'
    }
  }
}
const test = () => {
  const linkedList = new LinkedList()
  console.log(linkedList.toString())
  console.log(linkedList.size())
  linkedList.addHeader('4')
  linkedList.addHeader('3')
  linkedList.addHeader('2')
  linkedList.addHeader('1')
  linkedList.addTail('5')
  linkedList.addTail('6')
  linkedList.addTail('7')
  console.log(linkedList.size())
  console.log(linkedList.toString())
}
test()
module.exports = LinkedList
