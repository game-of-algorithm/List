/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} n
 * @return {ListNode}
 */
var removeNthFromEnd = function(head, n) {
  let move = head
  let move1 = new ListNode(null)
  move1.next = head
  head = move1
  let arr = []
  let node = null
  while (move !== null) {
    arr.push(move)
    move = move.next
  }
  for (let i = arr.length - 1; i >= 0; i--) {
    if (n + i === arr.length) {
      node = arr[i]
      break
    }
  }
  while (move1.next !== null) {
    if (move1.next === node) {
      move1.next = node.next
      break
    }
    move1 = move1.next
  }
  return head.next
}
