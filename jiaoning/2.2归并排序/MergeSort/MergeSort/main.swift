//
//  main.swift
//  MergeSort
//
//  Created by JAN on 2019/7/30.
//  Copyright © 2019年 synjones. All rights reserved.
//

import Foundation

print("Hello, World!")

var array = [5, 5, 3, 7, 4, 2, 5, 4, 9, 1, 8, 6]


//原地归并
func merge(array: inout Array<Int>, low: Int, mid: Int, high: Int) {
    var i = low, j = mid + 1
    var tempArr = array;
    for k in low...high {
        if(j > high){
            array[k] = tempArr[i]
            i += 1
        }else if(i > mid){
            array[k] = tempArr[j];
            j += 1
        }else if(tempArr[i] > tempArr[j]){
            array[k] = tempArr[j]
            j += 1
        }else{
            array[k] = tempArr[i]
            i += 1
        }
    }
}
//自顶向下
func downMergeSort(array : inout Array<Int>, low: Int, high: Int) {
    if(low >= high){
        return;
    }
    let mid = (low + high) / 2
    downMergeSort(array: &array, low: low, high: mid)
    downMergeSort(array: &array, low: mid+1, high: high)
    merge(array: &array, low: low, mid: mid, high: high)
}

//自地向下
func upMergeSort(array : inout Array<Int>) {
    let length = array.count
    var size = 1
    while size < length {
        var low = 0
        while low < length-size{
            merge(array: &array, low: low, mid: low+size-1, high: min(low+size+size-1, length-1))
            low += 2*size
        }
        size += size
    }
}

func main() {
//    let length = array.count
//    downMergeSort(array: &array, low: 0, high: length-1)
//    upMergeSort(array: &array)
//    print(array)
}

main()



/**
 2.2.4题
 是的，按顺序插入。  比如1 3 8 和2 0 7 9 原地归并之后会变成 1 2 0 3 7 8 9
 
 2.2.7  用NlogN 比较？(N+1)log(N+1)
 */

//链表排序
class Node {
    var val: Int
    var next: Node?
    init(_ val: Int) {
        self.val = val
        self.next = nil
    }
}

//链表原地归并
func mergeNode(head: Node, mid: Node, high: Node) -> (Node, Node) {
    if(mid.next === nil){
        return (head, high)
    }
    var lowNode = head.next, midNode = mid.next, highNode = high
    
    var cur = head //前一个结点，保证链表前后链接连贯
    let pre = Node(-1)
    while head !== high {
        if(lowNode!.val > midNode!.val){
            cur.next = midNode
            cur = cur.next!
            if(pre.next === nil){
                pre.next = midNode
            }
            if(midNode === highNode){
                let tmp = cur.next
                cur.next = lowNode
                mid.next = tmp
                return (pre.next!, mid)
            }else{
                midNode = midNode!.next
            }
        }else{
            cur.next = lowNode
            cur = cur.next!
            if(pre.next === nil){
                pre.next = lowNode
            }
            if(lowNode === mid){
                cur.next = midNode
                return (pre.next!, high)
            }else{
                lowNode = lowNode?.next!
            }
        }
    }
    return (pre.next!, high)
}

func sortListNode(head: Node, size: Int) -> (Node) {
    
    var pre = Node(-1)
    let new = Node(-1)
        if(pre.next === nil){
            pre.next = head
        }
        var low = head
        while low.next !== nil{
            var slow = pre
            var fast = pre
            for _ in 1...size{
                if(slow.next != nil){
                    slow = slow.next!
                }
                if(fast.next != nil){
                    fast = fast.next!
                }
                if(fast.next != nil){
                    fast = fast.next!;
                }
            }
            let result = mergeNode(head: pre, mid: slow, high: fast)
            if(new.next === nil){
                new.next = result.0
            }
            pre = result.1
            low = pre.next ?? (Node(-1))
        }
    return new.next!
}


func testMergeNodeList() {
    let node1 = Node(5)
    let node2 = Node(5)
    let node3 = Node(3)
    let node4 = Node(7)
    let node5 = Node(4)
    let node6 = Node(2)
    let node7 = Node(5)
    let node8 = Node(4)
    let node9 = Node(9)
    let node10 = Node(1)
    let node11 = Node(8)
    let node12 = Node(6)
    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5
    node5.next = node6
    node6.next = node7
    node7.next = node8
    node8.next = node9
    node9.next = node10
    node10.next = node11
    node11.next = node12
    node12.next = nil
    
    let head = Node(-1)
    head.next = node1
    
    let length = 12
    var size = 1
    var node = node1
    while size < length {
        node = sortListNode(head: node, size: size)
        size += size
    }
    
    while node.next !== nil {
        print(node.val)
        if(node.next !== nil){
            node = node.next!
        }
    }
    print(node.val)
    
}

testMergeNodeList()
