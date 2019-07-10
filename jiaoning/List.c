#include <stdio.h>

typedef struct Node{
    int data
    struct Node *next;
}Node

typedef struct Node *LinkList;

int main(void)
{
    int a = 1;
    int b = 2;
    int c = 0;

    c = a + b;
    
    printf("%d + %d = %d", a, b, c);

    return 0;
}
/*读取第i 个结点元素的值*/
int getValue(LinkList L, int i, int *value){
    int j;
    LinkList p;
    p = L.next;
    j = 1;
    while(p && j < i){
        p = p.next;
        j++
    }
    if(!p || j > i){
        return 0; //没找到
    }
    *value = p.data;
        return 1; //找到了
}   

/*在第i个结点的位置之前插入新数据元素value*/
int ListInsert(LinkList *L, int i; int value){
    int j;
    LinkList p,s;
    p = *L;
    j = 1;
    while(p && j < i){
        p = p.next;
        ++j;
    }   
    if(!p || j > i){
        return 0;
    }
    s = malloc(sizeof(Node)) 
    s.data = value;
    s.next = p.next; /*p是i的前一个结点，p是第j个结点的前一个*/
    p.next = s;
    return 1;
}

/*删除第i个结点并获取其值*/
int ListDelete(LinkList *L, int i; int *deleteValue){
    int j;
    LinkList p,q;
    p = *L;
    j = 1;
    while(p.next && j < i){
        p = p.next;
        ++j;
    }
    if(!p.next || j > i){
        return 0;
    }
    q = p.next;    /*q就是第i个*/
    p.next = q.next;
    *deleteValue = q.data;
    free(q)；
    return 1;
}

/*单链表反转*/
void reverse(LinkList *L){
    LinkList p, q, tmp;
    p = *L.next;
    q = NULL;
    while(p){
        tmp = p.next;
        p.next = q;
        q = p;
        p = tmp;
    }
    L.next = q;
    
    //
    LinkList p,q = *L;
    *L = NULL;
    while(q){
        p = q.next;
        q.next = L;
        L = q；
        q = p;
    }
}




