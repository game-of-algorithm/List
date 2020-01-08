//
//  main.swift
//  5.1字符串排序
//
//  Created by JiAoNing on 2020/1/2.
//  Copyright © 2020 纪奥宁. All rights reserved.
//

import Foundation


func charAt(s: String, d: Int) -> Int {
    let dic = ["a": 1,"b": 2,"c": 3,"d": 4,"e": 5,"f": 6,"g": 7,"h": 8,"i": 9,"j": 10,"k": 11,"l": 12,"m": 13,"n": 14,"o": 15,"p": 16,"q": 17,"r": 18,"s": 19,"t": 20,"u": 21,"v": 22,"w": 23,"x": 24,"y": 25,"z": 26]
    if d < s.count {
        let char = s[s.index(s.startIndex, offsetBy: d-1)]
//        let a = UnicodeScalar(String.init(char))
        return dic[String.init(char)]!
    }
    return 0;
}

func sort(a: inout [String], low: Int, high: Int, d: Int) {
    let R = 26;//26个字母
    var aux = a;
    var count = Array.init(repeating: 0, count: R+2)
    if low < high {
        for i in low...high {
            count[charAt(s: a[i], d: d) + 1] += 1 //计算频率
        }
        //频率转换为索引
        for r in 0...R {
            count[r+1] += count[r]
        }
        //数据分类
        for i in low...high {
            aux[count[charAt(s: a[i], d: d)]] = a[i]
            count[charAt(s: a[i], d: d)] += 1
        }
        //回写
        for i in low...high {
            a[i] = aux[i - low]
        }
        print(a)
        //递归
        for i in 0..<R {
            sort(a: &a, low: low + count[i], high: low + count[i+1]-1, d: d+1)
        }
    }
}

func quick3String(a: inout [String], low: Int, high: Int, d: Int) {
    if low >= high {
        return
    }
    var left = low
    var right = high
    let v = charAt(s: a[left], d: d)
    
    var i = left + 1
    while i <= right {
        let cur = charAt(s: a[i], d: d);
        if cur < v {
            a.swapAt(i, left)
            i += 1
            left += 1
        } else if cur > v {
            a.swapAt(i, right)
            right -= 1
        } else {
            i += 1
        }
    }
    quick3String(a: &a, low: low, high: left-1, d: d)
    if v > 0 {
        quick3String(a: &a, low: left, high: right, d: d+1)
    }
    quick3String(a: &a, low: right + 1, high: high, d: d)
}

func main() {
    var array = ["not", "is", "the", "time", "for", "all", "good", "people", "to", "come", "to", "aid", "of"]
//    sort(a: &array, low: 0, high: array.count-1, d: 1)
    quick3String(a: &array, low: 0, high: array.count - 1, d: 1)
    print(array)
}

main()
