class LeetCode148{
    public static void main(String[] args) {
        ListNode n1 = new ListNode(5);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(70);
        ListNode n4 = new ListNode(13);
        ListNode n5 = new ListNode(2);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        print(n1);
        System.out.println("");
        print(sortList(n1));
    }

    public static ListNode sortList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		// 使用快慢指针查找中间结点
		ListNode fast = head;
		ListNode slow = head;
		while (fast.next != null) {
			fast = fast.next.next;
			// 让slow少走一步，结点数目均匀
			if (fast == null)
				break;
			slow = slow.next;
		}
		ListNode right = slow.next;
		// 注意断链
		slow.next = null;
		
		ListNode left = sortList(head);
		right = sortList(right);
		return mergeTwoLists(left, right);
	}

    // 递归实现链表排序
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode res = null;
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		if (l1.val <= l2.val) {
			res = l1;
			l1.next = mergeTwoLists(l1.next, l2);
		} else {
			res = l2;
			l2.next = mergeTwoLists(l1, l2.next);
		}
		return res;
	}

    /**
     * 打印链表
     */
    public static void print(ListNode listNode) {
        System.out.print(listNode.val + (listNode.next == null ? "" : " -> "));
        if (listNode.next != null) {
            print(listNode.next);
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}