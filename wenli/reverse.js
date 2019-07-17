/**
 * 反转单链表
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
const reverseList = function(head) {
  if(head == null || head.next == null) {
    return head;
  }
  let pre = null;
  let next = null;
  while(head!=null) {
    next = head.next;
    head.next = pre;
    pre = head;
    head = next;
  }
  return pre
};


/**
 * k个一组反转链表
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**

