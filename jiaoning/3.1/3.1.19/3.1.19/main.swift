//
//  main.swift
//  3.1.19
//
//  Created by JAN on 2019/9/3.
//  Copyright © 2019年 synjones. All rights reserved.
//

import Foundation

class ST {
    var dictionary = [String: Int]()
    
    func put(_ key: String, _ value: Int) {
        if self.contains(key){
            dictionary.updateValue(get(key) + 1, forKey: key)
        }else{
             dictionary.updateValue(value, forKey: key)
        }
    }
    
    func get(_ key: String) -> Int {
        return dictionary[key] ?? 0
    }
    
    func contains(_ key: String) -> Bool {
        return dictionary[key] != 0
    }
    
    func keys() -> Array<String> {
        return Array(dictionary.keys)
    }
}

class Queue {
    var array = [String]()
    
    func put(_ key: String) {
        array.append(key)
    }
    func clean() {
        array.removeAll()
    }
}

class FreequencyCounter  {
    var st = ST()
    var queue = Queue()
    
    func main() {
        var max = "max"
        st.put(max, 0)

        for key in st.keys() {
            if st.get(key) == st.get("max"){
                queue.put(key) //相同继续保存
            }
            if st.get(key) > st.get("max"){
                max = key
                queue.clean() //清空之前的
                queue.put(key) //保存一份最新的
            }
        }
    }
}
