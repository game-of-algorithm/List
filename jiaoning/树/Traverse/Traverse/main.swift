//
//  main.swift
//  Traverse
//
//  Created by JAN on 2019/9/16.
//  Copyright © 2019年 synjones. All rights reserved.
//

import Foundation

var tree = ["A","B","C","D","E","F","G","H","I"];
/*      A
      /   \
     B     C
    /     / \
   D     E   F
  /\      \
 G  H      I
 */

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
//栈结构
class Stack {
    var array: Array<TreeNode>
    init() {
        array = [TreeNode]()
    }
    func isEmpty() -> Bool {
        return array.count == 0
    }
    
    func push(node: TreeNode) {
        array.append(node)
    }
    
    func pop() {
        array.removeLast();
    }
    
    func top() -> TreeNode {
        return array.last!
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
//递归前序遍历
func PreOrderTraversal(root: TreeNode?) {
    if(root != nil){
        print(root!.data, separator:"", terminator:" ");
        PreOrderTraversal(root: root!.left);     //访问左儿子
        PreOrderTraversal(root: root!.right);    //访问右儿子
    }
}//A B D G H C E I F

//非递归前序遍历
func PreOrderTraversalNormal(root: TreeNode?) {
    let stack = Stack.init()
    var node = root;
    while node != nil || !stack.isEmpty() {
        while node != nil {
            print(node!.data, separator:"", terminator:" ");
            stack.push(node: node!);
            node = node!.left
        }
        if(!stack.isEmpty()){
            node = stack.top()
            stack.pop();
            node = node!.right
        }
    }
}
//递归中序遍历
func InOrderTraversal(root: TreeNode?) {
    if(root != nil){
        InOrderTraversal(root: root!.left);     //访问左儿子
        print(root!.data, separator:"", terminator:" ");
        InOrderTraversal(root: root!.right);    //访问右儿子
    }
}//G D H B A E I C F
//非递归中序遍历
func InOrderTraversalNormal(root: TreeNode?) {
    let stack = Stack.init()
    var node = root;
    while node != nil || !stack.isEmpty() {
        while node != nil {
            stack.push(node: node!);
            node = node!.left
        }
        if(!stack.isEmpty()){
            node = stack.top()
            stack.pop();
            print(node!.data, separator:"", terminator:" ");
            node = node!.right
        }
    }
}

//递归后序遍历
func PostOrderTraversal(root: TreeNode?) {
    if(root != nil){
        PostOrderTraversal(root: root!.left);     //访问左儿子
        PostOrderTraversal(root: root!.right);    //访问右儿子
        print(root!.data, separator:"", terminator:" ");
    }
}//G H D B I E F C A
//非递归后序遍历
func PostOrderTraversalNormal(root: TreeNode?) {
    let stack1 = Stack.init()
    let stack2 = Stack.init()
    var node = root
    var cur: TreeNode?
    while node != nil || !stack1.isEmpty() {
        while node != nil {
            stack1.push(node: node!);
            stack2.push(node: node!);
            node = node!.right
        }
        if(!stack1.isEmpty()){
            node = stack1.top()
            stack1.pop();
            node = node!.left
        }
    }
    while !stack2.isEmpty() {
        node = stack2.top()
        stack2.pop();
        print(node!.data, separator:"", terminator:" ");
    }
}

//求树的深度递归
func treeDeep(root: TreeNode?) -> Int {
    if root == nil{
        return 0
    }
    let leftDeep = treeDeep(root: root?.left)
    let rightDeep = treeDeep(root: root?.right)
    return max(leftDeep, rightDeep) + 1
}

//求树的深度 非递归
func treeDeepNormal(root: TreeNode?) -> Int {
    if root == nil{
        return 0
    }
    let queue = Queue.init()
    var depth = 0
    queue.put(root!)
    while !queue.isEmpty() {
        depth += 1
        let count = queue.size()
        var cur = 0
        while(cur < count){
            let node = queue.out()
            cur += 1
            if(node!.left != nil){
                queue.put(node!.left!)
            }
            if(node!.right != nil){
                queue.put(node!.right!)
            }
        }
    }
    return depth
}

//反转二叉树 ,只要是遍历的时候对每个节点都进行左右子结点交换就完了？
func invertTree(_ root: TreeNode?) -> TreeNode? {
    if root != nil {
        let tmp = root!.left
        root!.left = root!.right
        root!.right = tmp
       let _ = invertTree(root!.left)
       let _ = invertTree(root!.right)
    }
    return root
}

func allSum() {
    let N = 20
    var sum = [Int]()
    var product = [Int]()
    var sumIJ = [(Int, Int)]()
    var productIJ = [(Int, Int)]()
    
    for i in 1..<N {
        for j in i+1...N {
            if !sum.contains(i+j){
                sum.append(i+j)
            }else{
                sumIJ.append((i, j))
            }
        }
    }
    for tup in sumIJ {
        if !product.contains(tup.0*tup.1){
            product.append(tup.0*tup.1)
        }else{
            productIJ.append(tup)
        }
    }
     print(productIJ)
}

func main() {
    let root = initTree()
    print("前序遍历:\n")
    PreOrderTraversal(root: root)
    print("\n")
    PreOrderTraversalNormal(root: root)
    print("\n中序遍历:\n")
    InOrderTraversal(root: root)
    print("\n")
    InOrderTraversalNormal(root: root)
    print("\n后序遍历:\n")
    PostOrderTraversal(root: root)
    print("\n")
    PostOrderTraversalNormal(root: root)
    
    print("\n树的深度:\n")
    print(treeDeep(root: root))
    print(treeDeepNormal(root: root))
    
    allSum()
//    invertTree(root)
//    print(treeDeepNormal(root: invertTree(root)))
}
main()
