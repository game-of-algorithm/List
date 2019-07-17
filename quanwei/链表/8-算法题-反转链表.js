const LinkList = require('./3-单向链表')
const _ = require('lodash')

// 生成一个链表
const listA = new LinkList()
_.forEach([-1, 1, 0, 3], num => {
  listA.append(num)
})
const { head: list1 } = listA

const reverseList1 = (list) => {
  if (!list) return null
  console.log('输入：')
  console.log(JSON.stringify(list))
  let current = list
  current.prev = null
  while (current.next) {
    current.next.prev = current
    current = current.next
  }
  let newCurrent = current
  while (newCurrent.prev) {
    const prev = newCurrent.prev
    delete newCurrent.prev
    newCurrent.next = prev
    if (!prev.prev) {
      prev.next = null
      delete prev.prev
    }
    newCurrent = prev
  }
  console.log('输出：')
  console.log(JSON.stringify(current))
  return {}
}

reverseList1(list1)
