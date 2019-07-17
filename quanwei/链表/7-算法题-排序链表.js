const LinkList = require('./3-单向链表')
const _ = require('lodash')

// 生成一个链表
const listA = new LinkList()
_.forEach([0, 3, -1, 2, 1, 8], num => {
  listA.append(num)
})
const { head: list1 } = listA
const getMin = (list) => {
  let current = list
  let min = current
  let prev = null
  while (current.next) {
    if (current.next.element < min.element) {
      min = current.next
      prev = current
    }
    current = current.next
  }
  if (!prev) list = min.next
  else prev.next = min.next
  return {
    min,
    newList: list
  }
}

const sortList1 = (list) => {
  if (!list) return null
  //
  console.log('输入：')
  console.log(JSON.stringify(list))
  //
  let sortedList = null
  let newList = list
  while (newList.next) {
    const result = getMin(newList)
    const min = result.min
    newList = result.newList
    //
    let last = null
    if (!newList.next) last = newList
    if (!sortedList) {
      sortedList = {
        element: min.element,
        next: null
      }
    } else {
      let cur = sortedList
      while (cur.next) cur = cur.next
      cur.next = {
        element: min.element,
        next: null
      }
      if (last) { // 把last连上去
        cur.next.next = {
          element: last.element,
          next: null
        }
      }
    }
  }
  console.log('输出：')
  console.log(JSON.stringify(sortedList))
  return sortedList
}

sortList1(list1)
