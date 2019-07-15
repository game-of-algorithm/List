//
//  Link_Algorithm.c
//  ListLink
//
//  Created by JiAoNing on 2019/7/14.
//  Copyright © 2019 纪奥宁. All rights reserved.
//

#include "Link_Algorithm.h"


struct ListNode {
    int val;
    struct ListNode *next;
};

/**链表反转，头插法*/
struct ListNode *reverseList(struct ListNode *head){
    
    struct ListNode *newList = NULL, *tmp;
    while (head) {
        tmp = head->next;
        head->next = newList;
        newList = head;
        head = tmp;
    }
    return newList;
}

/**链表反转，递归法*/
struct ListNode *reverseListRecursive(struct ListNode *head){
    if (head == NULL || head->next == NULL)
    {
        return head;
    }
    struct ListNode *newHead = reverseListRecursive(head->next);
    head->next->next = head;
    head->next = NULL;
    return newHead;
}

/**删除链表的倒数第n个结点，并返回链表的头结点*/
struct ListNode* removeNthFromEnd(struct ListNode* head, int n){
    int sum = 0;
    struct ListNode *node = head;
    while (node) {
        sum++;
        node = node->next;
    }
    /*正数第几个*/
    int tag = sum - n + 1;
    if(tag == 1){
        node = head->next;
        head = NULL;
        return node;
    }
    node = head;
    int i = 1;
    //找目标位置的前一个
    while (i < tag-1) {
        node = node->next;
        i++;
    }
    node->next = node->next->next;
    return head;
}

/**删除链表的倒数第n个结点，并返回链表的头结点  一次遍历*/
struct ListNode* removeNthFromEnd1(struct ListNode* head, int n){
    if(head == NULL){
        return head;
    }
    
    struct ListNode *rightNode = head;
    struct ListNode *leftNode = head;
    while (n > 0) {
        rightNode = rightNode->next;
        n--;
    }
    
    while (rightNode != NULL && rightNode->next != NULL) {
        rightNode = rightNode->next;
        leftNode = leftNode->next;
    }
    if(rightNode == NULL){
        head = head->next;
        return head;
    }
    if(leftNode != NULL && leftNode->next != NULL && leftNode->next->next != NULL){
        leftNode->next = leftNode->next->next;
    }else{
        leftNode->next = NULL;
    }
    
    return head;
}


/**排序链表*/

void swap(struct ListNode *first, struct ListNode *second){
    int tmpValue = first->val;
    first->val = second->val;
    second->val = tmpValue;
}

void quickSort(struct ListNode *head, struct ListNode *end){
    if(head == end)return;

    struct ListNode *letfNode = head;
    int value = letfNode->val;
    struct ListNode *cur = head->next;
    
    while(cur != NULL && cur != end){
        if(value > cur->val) {
            letfNode = letfNode->next;
            swap(letfNode, cur);
        }
        cur = cur->next;
    }
    head->val = letfNode->val;
    letfNode->val = value;
    quickSort(head, letfNode);
    quickSort(letfNode->next, end);
}

struct ListNode *sortList(struct ListNode* head){
    
    quickSort(head, NULL);
    return head;
}

