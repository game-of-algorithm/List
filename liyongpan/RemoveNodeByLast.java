public class RemoveNodeByLast {

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		if (n < 0) {
			return null;
		}
		if (n == 1) {
			return removeLast(head, head, n);
		}
		ListNode nHead = new ListNode(0);
		ListNode temp = nHead;
		for (int i = 1; i < n; i++) {
			if (i != 1) {
				temp.next = new ListNode(0);
				temp = temp.next;
			}
		}
		temp.next = head;
		return removeLast(head, nHead, n);
    }

	public static ListNode removeLast (ListNode head, ListNode nHead, int n) {
		ListNode prve = nHead;
		ListNode old = nHead;
		int i = 1;
		while (head.next != null) {
			head = head.next;
			prve = old;
			old = old.next;
			if (i < n) {
				nHead = nHead.next;
			}
			i++;
		}
		prve.next = prve.next.next;
		return nHead;
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
		ListNode head = removeNthFromEnd(l1, 3);
		print(head);
	}
}
