//
//  main.swift
//  QuickSort2.3.24
//
//  Created by JiAoNing on 2019/8/7.
//  Copyright © 2019 纪奥宁. All rights reserved.
//

import Foundation

//判断是否排序好
func isSorted(arr:Array<Int>) -> Bool{
    for i in 0..<arr.count-1 {
        if(arr[i] > arr[i+1]){
            return false
        }
    }
    return true;
}
//生成数组
func createArray() -> Array<Int> {
    var array = [Int]()
    for _ in 0...1000000 {
        array.append(Int(arc4random()%1000000))
    }
    return array
}

//单次快排
func quickSortReturnIndex(arr: inout Array<Int>, low: Int, high: Int) -> Int?{
    if(low >= high){
        return nil
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
    return j
}
//正常的排序
func sort(arr: inout Array<Int>, low: Int, high: Int) {
    if(low >= high){
        return
    }
    let k = quickSortReturnIndex(arr: &arr, low: low, high: high)
    let j: Int
    if(k == nil){
        return
    }
    j = k!
    sort(arr: &arr, low: low, high: j-1)
    sort(arr: &arr, low: j+1, high: high)
}

//
func quickSortBySamples(arr: inout Array<Int>, samplLow: Int, low: Int, high: Int, samplHigh: Int) {
    if(low >= high){
        return
    }
    //这个low位置就是之前抽样中的mid，先通过mid找到他在low - high之间的位置,
    let k = quickSortReturnIndex(arr: &arr, low: low, high: high)
    if(k == nil){
        return
    }
    let j = k!
    //现在数组是左边1/2取样，右边1/2取样，中间有这个j
    //如果左边的取样还有更多，那么继续分开一半，放到j前面，同样后面的取样如果多，分一半放到j后面。
    //如果取样不足，直接用快排
    if(low - samplLow > 1){
        var i = low - 1//指向取样的最后一个位置
        var v = j - 1//指向这部分的最后一个位置
        //像开始一样，把取样的一半放到这部分的最后面
        let mid = (low - samplLow) / 2
        while i != mid{
            arr.swapAt(i, v)
            i -= 1
            v -= 1
        }
        //再排前一段
        quickSortBySamples(arr: &arr, samplLow: samplLow, low: mid, high: v, samplHigh: j-1);
    }else{
        sort(arr: &arr, low: samplLow, high: j-1)
    }
    
    //分后面一段取样
    if(samplHigh - high > 1){
        var i = high //指向后半段取样的第一个位置
        var v = j //指向这部分的第一个位置
        //像开始一样，把取样的一半放到这部分的最后面
        let mid = (samplHigh - high) / 2
        for _ in 0..<mid{
            i += 1
            v += 1
            arr.swapAt(i, v)
        }
        //再排后一段
        quickSortBySamples(arr: &arr, samplLow: j+1, low: v, high: i, samplHigh: samplHigh);
        
    }else{
        sort(arr: &arr, low: j+1, high: samplHigh)
    }
}

func main() {
    var array = createArray()
    var arrayCopy = array
    
    
    let sampl = 3
    sort(arr: &array, low: 0, high: sampl)
    //取样中间数
    let samplMid = sampl / 2
    //取样的后半段放到数组里
    var i = sampl, j = array.count - 1;
    while i != samplMid {
        array.swapAt(i, j);
        i -= 1;
        j -= 1;
    }
    let startTime1 = CFAbsoluteTimeGetCurrent()
    quickSortBySamples(arr: &array, samplLow: 0, low: samplMid, high: j, samplHigh: array.count-1)
    let endTime1 = CFAbsoluteTimeGetCurrent()
    debugPrint("取样排序时长：%f 毫秒", (endTime1 - startTime1))
    
    
    let startTime2 = CFAbsoluteTimeGetCurrent()
    sort(arr: &arrayCopy, low: 0, high: arrayCopy.count-1)
    let endTime2 = CFAbsoluteTimeGetCurrent()
    
    debugPrint("直接排序时长：%f 毫秒", (endTime2 - startTime2))
        
    print(isSorted(arr: array))
    print(isSorted(arr: arrayCopy))
}
main()

