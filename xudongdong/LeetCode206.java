/**
 * 单链表反转，递归和非递归方法
 */
class LeetCode206{
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
        reverseList(n1);
        System.out.println("");
        print(n5);

    }

    /**
     * 递归
     */
    public static void reverseNode(ListNode head){
        //头结点为空或者只有头结点
        if(head == null || head.next == null){
            return;
        }
        reverseNode(head.next);
        head.next.next = head;
        head.next = null;
    }

    /**
     * 非递归
     */
    public static void reverseList(ListNode head){
        if(head == null || head.next == null){
            return;
        }

        ListNode pre = null;//上一个节点
        ListNode current = head;//当前节点
        ListNode temp;
        while(current != null){
            temp = current.next;
            
            current.next = pre;
            pre = current;
            current = temp;
        }
        return;
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