//
//  main.swift
//  3.2.38
//
//  Created by JAN on 2019/9/24.
//  Copyright © 2019年 synjones. All rights reserved.
//

import Foundation

class TreeNode {
    let data: String
    var left: TreeNode?
    var right: TreeNode?
    var x: Int = 0
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

func initTree() -> TreeNode {
    let I = TreeNode.init("I", nil, nil)
    let H = TreeNode.init("H", nil, nil)
    let G = TreeNode.init("G", nil, nil)
    
    let F = TreeNode.init("F", nil, nil)
    let E = TreeNode.init("E", nil, I)
    let D = TreeNode.init("D", G, H)
    
    let C = TreeNode.init("C", E, F)
    let B = TreeNode.init("B", D, nil)
    let A = TreeNode.init("A", B, C)
    
    return A;
}

func treeCount(root: TreeNode?) -> Int {
    if root == nil {
        return 0
    }
    return treeCount(root: root?.left) + treeCount(root: root?.right) + 1
}

func leftCount(root: TreeNode?) -> Int {
    return treeCount(root: root?.left)
}

func configIndex(root: TreeNode?, offset: Int) {
    if root == nil{
        return
    }
    let queue = Queue.init()
    queue.put(root!)
    while !queue.isEmpty() {
        let node = queue.out()
        let leftNum = leftCount(root: node)
        node!.x = leftNum + offset
        if node!.left != nil {
            configIndex(root: node!.left!, offset: offset)
            print("\(offset)")
            queue.put(node!.left!)
        }
        if(node!.right != nil){
            configIndex(root: node!.right!, offset: node!.x + 1)
            queue.put(node!.right!)
        }
    }
}

func draw(root: TreeNode?) {
    if root == nil{
        return
    }
    let queue = Queue.init()
    queue.put(root!)
    while !queue.isEmpty() {
        print("\n", separator: "", terminator: "")
        let count = queue.size()
        var cur = 0
        
        while(cur < count){
            let node = queue.out()!
            for _ in 0..<node.x {
                print(" ", separator: "", terminator: "")
            }
            print(node.data, separator: "", terminator: "")
            cur += 1
            if(node.left != nil){
                queue.put(node.left!)
            }
            if(node.right != nil){
                queue.put(node.right!)
            }
        }
    }
}

func main() {
    let root = initTree()
    configIndex(root: root, offset: 0)
    draw(root: root)
}

main()
