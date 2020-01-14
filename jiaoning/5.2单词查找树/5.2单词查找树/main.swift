//
//  main.swift
//  5.2单词查找树
//
//  Created by JAN on 2020/1/14.
//  Copyright © 2020 synjones. All rights reserved.
//

import Foundation

class Node {
    var value: Int = 0
    var next: [Node] = []
    var left: Node = Node()
    var mid: Node = Node()
    var right: Node = Node()
    var char: Character = ""  //当做是下标
}

func get(x: Node?, key: String, d: Int) -> Node? {
    if x == nil {
        return nil
    }
    if d == key.count {
        return x
    }
    let c = key.index(key.startIndex, offsetBy: d)//转为字符集中的index，在x?.next[c]
    return get(x: x?.next[0], key: key, d: d+1)
}

//非递归
func getNormal(x: Node?, key: String, d: Int) -> Node?{
    var cur = x
    var index = d
    while cur != nil {
        if index == key.count {
            return cur
        }
        let c = key.index(key.startIndex, offsetBy: index)//转为字符集中的index，在x?.next[c]
        cur = cur?.next[c]
        index += 1
    }
    return cur
}

//三向非递归put
func putNormal(root:Node, key: String, value: Int) -> Node {
    var cur = root
    var index = 0
    let c = key.index(key.startIndex, offsetBy: index)
    while true {
        let c = key.index(key.startIndex, offsetBy: index)//转为字符集中的index，在x?.next[c]
        if cur == nil {
            let cur = Node()
            cur.char = c
            cur = cur.mid
            index += 1
        }else if c < cur.char {
            cur = cur.left
        } else if c > cur.char {
            cur = cur.right
        } else if index < key.count - 1 {
            cur = cur.mid
            index += 1
        } else {
            cur.value = value
            return cur
        }
    }
    return cur
}
