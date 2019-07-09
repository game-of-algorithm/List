#include <iostream>

// Single linked list
struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

// Double linked list
struct DoubleListNode {
    int val;
    DoubleListNode *next;
    DoubleListNode *prev;
    DoubleListNode(int x) : val(x), next(NULL), prev(NULL) {}
};

/**
 * 特点：随机插入和删除效率高，查询效率低
 */

/**
 * 1. 单链表就地反转
 */

void reverse(ListNode *head) {
    
    if (head == NULL || head->next == NULL)
    {
        return;
    }

    reverse(head->next);
    head->next->next = head;
    head->next = NULL;
}

/**
 * 2. 给定一个单向链表（长度未知），请遍历一次就找到中间的指针，假设该链表存储在只读存储器，不能被修改
 */

ListNode *findMid(ListNode *head) {
    if (head == NULL)
    {
        return head;
    }

    ListNode *p1,*p2;
    p1 = head;
    p2 = head;

    bool flag = true;

    while (p2->next != NULL) {
        p2 = p2->next;
        if (flag) {
            p1 = p1->next;
        }
        flag = !flag;
    }
    
    return p1;
}