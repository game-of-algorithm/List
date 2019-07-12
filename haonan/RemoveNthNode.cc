/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。给定的 n 保证是有效的。
 * 你能尝试使用一趟扫描实现吗？
 */

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */

#include <vector>

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        if (head == nullptr)
        {
            return head;
        }

        ListNode *lNode = head;
        ListNode *rNode = head;

        // 大于零停在被删节点的前一节点
        while (n > 0)
        {
            rNode = rNode->next;
            n--;
        }
        
        while (rNode->next != nullptr)
        {
            rNode = rNode->next;
            lNode = lNode->next;
        }
        
        if (lNode->next != nullptr && lNode->next->next != nullptr)
        {
            lNode->next = lNode->next->next;
        } else {
            lNode->next = nullptr;
        }
        
        return head;
    }
};