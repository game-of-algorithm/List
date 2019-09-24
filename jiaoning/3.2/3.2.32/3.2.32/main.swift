//
//  main.swift
//  3.2.32
//
//  Created by JAN on 2019/9/24.
//  Copyright © 2019年 synjones. All rights reserved.
//

import Foundation

class TreeNode {
    let data: I
    var left: TreeNode?
    var right: TreeNode?
    init(_ data: String, _ left:TreeNode?, _ right:TreeNode?) {
        self.data = data
        self.left = left
        self.right = right
    }
}

func treeCount(root: TreeNode?) -> Int {
    if root == nil {
        return 0
    }
    return treeCount(root: root?.left) + treeCount(root: root?.left) + 1
}

//3.2.29
func isBinarytree(root: TreeNode?, N: Int) -> Bool {
    let count = treeCount(root: root)
    return count == N
}

//3.2.30
func isOrdered(root: TreeNode?) -> Bool {
    if root == nil {
        return true
    }
    if root?.left != nil && root?.left?.data >= root?.data {
        return false
    }
    if root?.right != nil && root?.right?.data <= root?.data {
        return false
    }
    return true
}


func has(root:TreeNode?, dict: inout Dictionary<String, Bool>) -> Bool {
    if root == nil {
        return true
    }
    if dict[root!.data] ?? false == true {
        return false
    }else {
        dict[root!.data] = true
    }
    return has(root: root?.left, dict: &dict) && has(root: root?.right, dict: &dict)
}
//3.2.31
func hasNoDuplicates(root: TreeNode?) -> Bool {
    
    var dict = Dictionary<String, Bool>()
    return has(root: root, dict: &dict)
}

//3.2.32
func isBST(root: TreeNode?) -> Bool {
    let N = 10//结点数
    if root == nil {
        return false
    }
    if isBinarytree(root: root, N: N) && isOrdered(root: root) && hasNoDuplicates(root: root) {
        return true
    }else {
        return false
    }
}

