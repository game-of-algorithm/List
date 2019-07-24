/**
 * O(n log n) 并归排序
 * @author liyongpan
 *
 */
public class SortCode {

	public static ListNode sortList (ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 快慢指针 快指针为null时慢指针为中间
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
        	fast = fast.next.next;
        	slow = slow.next;
        }
        ListNode right = slow.next;
        slow.next = null;
        head = sortList(head);
        right = sortList(right);
        return mergeList(head, right);
    }

	public static ListNode mergeList (ListNode list1, ListNode list2) {
		if (list1 == null) return list2;
		if (list2 == null) return list1;

		ListNode nList = null;
		if (list1.val > list2.val) {
			nList = list2;
			list2.next = mergeList(list2.next, list1);
		} else {
			nList = list1;
			list1.next = mergeList(list1.next, list2);
		}

		return nList;
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
//		ListNode l1 = new ListNode(4);
//		ListNode l2 = new ListNode(2);
//		ListNode l3 = new ListNode(1);
//		ListNode l4 = new ListNode(3);
//		l3.next = l4;
//		l2.next = l3;
//		l1.next = l2;
//		ListNode head = sortList(l1);
//		print(head);

		ListNode l1 = new ListNode(-1);
		ListNode l2 = new ListNode(5);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(0);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		ListNode head = sortList(l1);
		print(head);
	}
}
