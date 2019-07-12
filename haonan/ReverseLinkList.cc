/**
 * 反转一个单链表。
 */

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */

#include <stack>
using std::stack;

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    // 递归解法
    ListNode* reverseList1(ListNode* head) {
        if (head == nullptr || head->next == nullptr)
        {
            return head;
        }
        
        ListNode *node = reverseList1(head->next);
        node->next = head;
        head->next = nullptr;
        return head;
    }

    // 利用栈解法
    ListNode* reverseList2(ListNode* head) {
        if (head == nullptr || head->next == nullptr)
        {
            return head;
        }
        
        stack<ListNode *> stack;
        while (head)
        {
            stack.push(head);
            head = head->next;
        }
        
        head = stack.top();
        stack.pop();

        while (stack.top() != nullptr)
        {
            ListNode *topNode = stack.top();
            head->next = topNode;
            head = topNode;
        }

        return head;
    }
};