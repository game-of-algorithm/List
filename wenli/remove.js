/**
 * 删除链表的倒数第N个节点
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
const removeNthFromEnd = (head, n) => {
  let fast = head;
  let slow = head;
  while( n>0 ){
    fast = fast.next;
    n--;
  }
  if(!fast){
    // 删除了头结点
    return head.next;
  };
  while( fast.next ){
    fast = fast.next;
    slow = slow.next;
  }
  slow.next = slow.next.next;
  return head
};
