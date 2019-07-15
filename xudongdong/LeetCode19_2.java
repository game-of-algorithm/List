import java.util.ArrayList;
import java.util.Arrays;

/**
 * 19. 删除链表的倒数第N个节点 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 */
class LeetCode19_2 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        print(n1);
        System.out.println("");
        removeNthFromEnd(n1, 2);
        print(n1);
    }

    /**
     * 定义两个指针，第一个指针进行遍历，第二个指针为第一个指针的前n个节点
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null && n == 1)
            return null;
        ListNode node = head;
        ListNode delete = null;

        while (node != null) {
            if (n > 0)
                n--;
            else if (delete == null)
                delete = head;
            else
                delete = delete.next;
            node = node.next;
        }

        if (delete != null)
            delete.next = delete.next.next;
        else if (n == 0)
            head = head.next;
        return head;

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