public class ReverseCode {

	public static ListNode reverseList (ListNode head) {
        if (head == null) {
            return head;
        }
    	return reverseList(head, head, head.next);
    }

	// current = 当前递归项
	/**
	 *
	 * @param head 新链表头
	 * @param last 新链表尾
	 * @param current 当前递归项
	 * @return
	 */
	public static ListNode reverseList (ListNode head, ListNode last, ListNode current) {
        if (current == null) {
            return head;
        }

        last.next = current.next;
        ListNode temp = current.next;
        current.next = head;
        return reverseList(current, last, temp);
    }

	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

	public static void print (ListNode head) {
		String str = head.val + "";
		while (head.next != null) {
			head = head.next;
			str += "->" + head.val;
		}
		System.out.println(str);
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		ListNode head = reverseList(l1);
		print(head);
	}
}
