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
var sortList = function(head) {
  let newHead = null
  let newNextHead = null
  while (head !== null) {
    const oldValue = head.val
    const node = new ListNode(oldValue)
    if (newHead === null) {
      newHead = node
    } else {
      newNextHead = newHead
      if (newNextHead.val >= oldValue) {
        node.next = newNextHead
        newNextHead = newHead = node
      } else {
        let nextHead = newNextHead.next
        while (newNextHead !== null && nextHead !== null) {
          if (newNextHead.val <= oldValue && oldValue <= nextHead.val) {
            node.next = nextHead
            newNextHead.next = node
            break
          } else {
            newNextHead = newNextHead.next
            nextHead = newNextHead.next
          }
        }
        if (nextHead === null) {
          newNextHead.next = node
        }
      }
    }
    head = head.next
  }
  return newHead
}
