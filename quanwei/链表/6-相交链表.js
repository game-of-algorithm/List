
// 编写一个程序，找到两个单链表相交的起始节点。

// 如果两个链表没有交点，返回 null.
// 在返回结果后，两个链表仍须保持原有的结构。
// 可假定整个链表结构中没有循环。
// 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。

const _ = require('lodash')
const logger = require('../utils/logger')

const intersetval1 = {
  val: 8,
  next: {
    val: 4,
    next: {
      val: 5,
      next: null
    }
  }
}
const listA1 = {
  val: 4,
  next: {
    val: 1,
    next: intersetval1
  }
}

const listB1 = {
  val: 5,
  next: {
    val: 0,
    next: {
      val: 1,
      next: intersetval1
    }
  }
}

const listA2 = {
  val: 4,
  next: {
    val: 1,
    next: null
  }
}

const listB2 = {
  val: 5,
  next: {
    val: 0,
    next: {
      val: 1,
      next: null
    }
  }
}

const getLength = (litNode) => {
  let length = 1
  while (litNode.next !== null) {
    length++
    litNode = litNode.next
  }
  return length
}

const cutListNode = (listNode, cutLength) => {
  while (cutLength > 0) {
    listNode = listNode.next
    cutLength--
  }
  return listNode
}

const getIntersectionNode = (listNodeA, listNodeB) => {
  if (_.isEmpty(listNodeA) || _.isEmpty(listNodeB)) return null
  let a = listNodeA
  let b = listNodeB
  const aLength = getLength(a)
  const bLength = getLength(b)
  a = aLength > bLength ? cutListNode(a, aLength - bLength) : a
  b = bLength > aLength ? cutListNode(b, bLength - aLength) : b

  // 对象比较： 比较的是引用地址，不是每层的键值对相等
  while (a !== b) {
    a = a.next || null
    b = b.next || null
  }
  logger.info(listNodeA)
  logger.info(listNodeB)
  logger.info(`链表的相交节点：`, a)
  return a
}

// getIntersectionNode(listA1, listB1)
// logger.info('-----------------------')
// getIntersectionNode(listA2, listB2)

// 将两个链表连起来，长度相等了，就可以直接判断第哪个节点是相同的
// const getIntersectionNode1 = function(headA, headB) {
//   let a = headA
//   let b = headB
//   // while条件：a和b相等且不为null； a和b都是null。
//   while (a !== b) {
//     // 谁遍历完谁就连接另一个, 如果没有相交，a、b最后都是null
//     因为js的对象是引用地址，没法直接连接，所以用了两段式的赋值
//     a = a == null ? headB : a.next
//     b = b == null ? headA : b.next
//   }
//   return a
// }

// console.log(getIntersectionNode1(listA1, listB1))
