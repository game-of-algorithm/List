//
//  main.swift
//  HeapSort
//
//  Created by JAN on 2019/8/20.
//  Copyright © 2019年 synjones. All rights reserved.
//

import Foundation

var array = [0, 5, 3, 7, 4, 2, 11, 10, 9, 1, 8, 6]

//下沉
func sink(arr: inout Array<Int>, k: Int, N: Int) -> Int {
    var nums = 0
    var i = k
    while 2*i <= N {
        var j = 2*i
        nums += 1//两个子节点比较大小
        if j < N && arr[j] < arr[j+1]{
            j += 1
        }
        nums += 1//父节点与子节点比较
        if arr[j] > arr[i]{
            arr.swapAt(i, j)
            i = j
        }else{
            break
        }
    }
    return nums
}

//上浮
func swim(arr: inout Array<Int>, k: Int) {
    var i = k
    while i > 1 && arr[i] > arr[i/2] {
        arr.swapAt(i, i/2)
        i = i/2
    }
}
//dui
func heapSort(arr: inout Array<Int>) {
    var times = 0;
    
    var N = arr.count-1
    for k in (1...N/2).reversed() {
       times += sink(arr: &arr, k: k, N: N)
    }
    while N > 1 {
        arr.swapAt(1, N);
        N -= 1
       times += sink(arr: &arr, k: 1, N: N)
    }
    print("堆排序比较次数:\(times)")
}

//2.4.16
func onlySink(arr: inout Array<Int>, k: Int, N: Int) {
    var i = k
    var last = arr[k] //记录需要下沉出来的数
    
    while 2*i < N {
        let tmp = arr[2*i+1]
        arr[2*i+1] = last
        last = tmp
        i = 2*i+1
    }
    arr[k] = last//把最下面的数放在最顶部，相反，做下沉操作的时候他就需要比较次数最多
}

//最差序列
func getWorstArray() -> Array<Int> {
    var arr = [Int]()
    arr.append(0)
    for i in (1...31).reversed() {
        arr.append(i)
    }
    let N = arr.count-1
    
    for i in 1...N/2 {
        onlySink(arr: &arr, k: i, N: N)
    }
    print("最差序列:\(arr)");
    return arr
    
}
//最优序列
func getBestArray() -> Array<Int> {
    var arr = [Int]()
    arr.append(0)
    for i in (1...31).reversed() {
        arr.append(i)
    }
    let N = arr.count-1
    
    for i in 1...N/2 {
        onlySink(arr: &arr, k: i, N: N)
    }
    print("最差序列:\(arr)");
    return arr
    
}
func main() {
    var worstArr = getWorstArray()
    heapSort(arr: &worstArr)
    print(worstArr);
}

main()
