import java.util.ArrayList;
import java.util.Arrays;

/**
 * 19. 删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 这么写 很LOW
 */
class LeetCode19{
    static ArrayList<ListNode> temp = new ArrayList<>();
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
        transform(n1);

        removeNthFromEnd(n1, 2);
        for(ListNode n : temp){
            System.out.print(n.val + " ");
        }
        System.out.println("");
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        temp.clear();
        transform(head);
        temp.remove(temp.size() - n);
        if(temp.size() == 0){
            return null;
        }

        ListNode newHead = temp.get(0);
        ListNode tempNode = newHead;
        for(int i = 1; i < temp.size(); i++){
            tempNode.next = temp.get(i);
            tempNode = temp.get(i);
        }
        temp.get(temp.size() - 1).next = null;
        return temp.get(0);
    }

    public static void transform(ListNode head){
        if(head == null){
            return;
        }

        temp.add(head);
        if(head.next != null){
            transform(head.next);
        }
    }

    /**
     * 打印链表
     */
    public static void print(ListNode listNode){
        System.out.print(listNode.val + (listNode.next == null ? "":" -> "));
        if(listNode.next != null){
            print(listNode.next);
        }
    }

 public static class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
    }
}