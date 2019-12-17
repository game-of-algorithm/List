//
//  main.swift
//  LeetCode习题
//
//  Created by JAN on 2019/12/17.
//  Copyright © 2019 synjones. All rights reserved.
//

import Foundation

//快速排序
func quickSort(arr: inout Array<Int>, low: Int, high: Int){
    if(low >= high){
        return;
    }
    var i = low + 1;
    var j = high;
    let key = arr[low];
    while true {
        while (key > arr[i]){
            if(i == high){
                break;
            }
            i += 1;
        }
        while (key < arr[j]){
            if(j == low){
                break;
            }
            j -= 1;
        }
        if(i >= j){
            break
        }
        arr.swapAt(i, j)
        i += 1;
        j -= 1;
    }
    arr.swapAt(low, j);

    quickSort(arr: &arr, low: low, high: j-1)
    quickSort(arr: &arr, low: j+1, high: high)
}


func largestPerimeter(_ A: [Int]) -> Int {
    var array = A
    quickSort(arr: &array, low: 0, high: A.count-1)
    var count = A.count
    while count >= 3 {
        if array[count-1] < array[count-2] + array[count-3] {
            return array[count-1] + array[count-2] + array[count-3]
        }
        count -= 1
    }
    return 0
}



class KthLargest {
    var priorityQueue = [Int]()
    var K = 0
    //下沉
    func sink(arr: inout Array<Int>, k: Int, N: Int) {
        var i = k
        while 2*i+1 <= N {
            var j = 2*i+1
            //两个子节点比较大小
            if j < N && arr[j] > arr[j+1]{
                j += 1
            }
            //父节点与子节点比较
            if arr[j] < arr[i]{
                arr.swapAt(i, j)
                i = j
            }else{
                break
            }
        }
    }
    
    init(_ k: Int, _ nums: [Int]) {
        K = k
        for item in nums {
            if priorityQueue.count < k {
                priorityQueue.append(item)
            } else {
                if item > priorityQueue.first! {
                    priorityQueue[0] = item
                    sink(arr: &priorityQueue, k: 0, N: priorityQueue.count-1)
                }
            }
        }
    }
    
    func add(_ val: Int) -> Int {
        if priorityQueue.count < K {
            priorityQueue.insert(val, at: 0)
            sink(arr: &priorityQueue, k: 0, N: priorityQueue.count-1)
        } else {
            if val > priorityQueue.first! {
                priorityQueue[0] = val
                sink(arr: &priorityQueue, k: 0, N: priorityQueue.count-1)
            }
        }
        
        return priorityQueue.first!
    }
}

func main() {
    let n = KthLargest(3, [12,2,9])
    print(n.add(-3))
    print(n.add(-2))
    print(n.add(-4))
    print(n.add(0))
    print(n.add(4))
    print(n.add(5))
    print(n.add(6))
    print(n.add(7))
    print(n.add(8))
    print(n.add(9))
    print(n.add(10))
    
}

main()
