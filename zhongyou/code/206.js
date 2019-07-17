/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var reverseList = function(head) {
  let array = []
  let reHead = null
  let m = null
  while (head !== null) {
    array.push(head)
    head = head.next
  }
  for (let i = array.length - 1; i >= 0; i--) {
    let a = array[i]
    if (a.next === null) {
      m = reHead = a
    }
    if (a.next === m) {
      a.next = null
      m.next = a
      m = a
    }
  }

  return reHead
}
