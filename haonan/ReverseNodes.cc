/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 */

#include <vector>
using std::vector;

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    ListNode* reverseKGroup(ListNode* head, int k) {
        if (head == nullptr || head->next == nullptr)
        {
            return head;
        }

        ListNode *node = new ListNode(0);

        while (head)
        {
            vector<ListNode *> tmpvt;
            int i = k;
            
            while (head != nullptr && k > 0)
            {
                tmpvt.push_back(head);
                k--;
                head = head->next;
            }

            if (k > 0)
            {
                for (int j = 0; j < tmpvt.size(); j++)
                {
                    node->next = tmpvt[j];
                    node = node->next;
                }
                
                break;
            } else {
                 for (int j = tmpvt.size() - 1; j >= 0; j++) {
                    node->next = tmpvt[j];
                    node = node->next;
                }
            }
            
        }
        
        return node->next;
    }
};