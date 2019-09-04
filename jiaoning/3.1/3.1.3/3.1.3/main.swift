//
//  main.swift
//  3.1.3
//
//  Created by JAN on 2019/9/3.
//  Copyright © 2019年 synjones. All rights reserved.
//

import Foundation
struct Test {
    
}
//结构
class Node {
    var value: Int
    var key: String
    var next: Node?
    init(key:String, value: Int) {
        self.value = value
        self.key = key
    }
}

class OrderedSequentialSearchST {
    var count: Int
    var head: Node?
    init(){
        count = 0
        head = nil
    }
    
    func put(key: String, value: Int) {
        
        let tmp = Node.init(key: key, value: value)
        
        var pre: Node?
        var cur = head;
        if cur == nil {
            head = tmp
        }else{
            while (cur != nil && less(cur!.key, tmp.key))
            {
                pre = cur!
                cur = cur!.next
            }
            //tmp小于第一个cur
            if pre == nil{
                tmp.next = head
                head = tmp
            }
            //一直没有找到位置
            if cur == nil{
                pre!.next = tmp
            }else{
                tmp.next = cur;
                pre!.next = tmp;
            }
        }
        count += 1
    }
    
    func get(key: String) -> Int {
        while (head != nil) {
            if head!.key == key{
                return head!.value
            }
            head = head!.next
        }
        return 0
    }
    
    func delete(key: String)  {
        if head == nil{
            return
        }
        if head?.key == key{
            head = head?.next
        }else{
            var pre = head!
            var cur = head?.next
            
            while (cur != nil) {
                if cur!.key == key{
                    pre.next = cur!.next
                }else{
                    pre = cur!
                    cur = cur?.next
                }
            }
        }
    }
    
    func contains(key: String) -> Bool {
        var cur = head
        while (cur != nil) {
            if cur!.key == key{
                return true
            }
            cur = cur!.next
        }
        return false
    }
    
    func isempty() -> Bool {
        return count == 0
    }
    
    func size() -> Int {
        return count
    }
    
    func min() -> String {
        return head?.key ?? ""
    }
    
//    func max() -> String {
//
//    }
//    //小于等于key的最大键
//    func floor(key: String) -> String {
//
//    }
//    //大于等于key的最小键
//    func ceiling(key: String) -> String {
//
//    }
    //小于key的键的数量
    func rank(key: String) -> Int {
        var cur = head
        var num = 0
        while (cur != nil) {
            if less(cur!.key, key){
                num += 1
            }
            cur = cur!.next
        }
        return num
    }
//    //排名为key的键
//    func select(k: Int) -> String {
//
//    }
//    //删除最小的键
//    func deleteMin() {
//
//    }
//    //删除最大的键
//    func deleteMax() {
//
//    }
    //比较
    func less(_ firstKey: String, _ secondKey: String) -> Bool {
        return firstKey < secondKey
    }
    
}
