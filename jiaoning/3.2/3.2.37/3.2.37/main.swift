//
//  main.swift
//  3.2.37
//
//  Created by JAN on 2019/9/24.
//  Copyright © 2019年 synjones. All rights reserved.
//

import Foundation

class TreeNode {
    let data: String
    var left: TreeNode?
    var right: TreeNode?
    init(_ data: String, _ left:TreeNode?, _ right:TreeNode?) {
        self.data = data
        self.left = left
        self.right = right
    }
}

//队列结构
class Queue {
    var array = [TreeNode]()
    
    func put(_ key: TreeNode) {
        array.append(key)
    }
    func out() -> TreeNode? {
        let first =  array.first
        if(first != nil){
            array.removeFirst()
        }
        return first
    }
    func isEmpty() -> Bool {
        return array.count == 0
    }
    func size() -> Int {
        return array.count
    }
    func clean() {
        array.removeAll()
    }
}

func levelPrint(root: TreeNode?) {
    if root == nil{
        return
    }
    let queue = Queue.init()
    queue.put(root!)
    while !queue.isEmpty() {
        let node = queue.out()
        print(node!)
        if(node!.left != nil){
            queue.put(node!.left!)
        }
        if(node!.right != nil){
            queue.put(node!.right!)
        }
    }
}
