/**
 * 1. 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 */

#include <vector>
using std::vector;

// Definition for singly-linked list.
 struct ListNode {
     int val;
     ListNode *next;
     ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    ListNode* sortList(ListNode* head) {
        
        if (head == NULL || head->next == NULL) {
            return head;
        }
        
        vector<ListNode *> vt;
        while (head) {
            vt.push_back(head);
            head = head->next;
        }
        
        quickSort(vt, 0, vt.size() - 1);

        for (int i = 0; i < vt.size() - 1; i++)
        {
            vt[i]->next = vt[i+1];
        }
        
        return vt[0];
    }

    void quickSort(vector<ListNode *> vt, int l, int r) {
        if (l < 0 || r < 0) {
            return;
        }

        if (l < r)
        {
            int i = l, j = r;
            ListNode *tmp = vt[l];

            while (i < j)
            {
                while (i < j && vt[j]->val > tmp->val)
                {
                    j--;
                }
                
                if (i < j)
                {
                    vt[i++] = vt[j];
                }

                while (i < j && vt[i]->val < tmp->val)
                {
                    i++;
                }
                
                if (i < j)
                {
                    vt[j--] = vt[i];
                }
                
            }

            vt[i] = tmp;
            
            quickSort(vt, l, i - 1);
            quickSort(vt, i + 1, r);
        }
        
    }
};

