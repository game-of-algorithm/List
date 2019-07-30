//
//  main.swift
//  SwiftSort
//
//  Created by JAN on 2019/7/23.
//  Copyright © 2019年 synjones. All rights reserved.
//

import Foundation

print("Hello, World!")

var array = [5, 5, 3, 7, 4, 2, 5, 4, 9, 1, 8, 6]

//选择排序
func selectionSort(arr : inout Array<Int>) {
    var minIndex : Int //记录最小下标
    for i in 0..<arr.count - 1 {
        minIndex = i;
        for j in i..<arr.count {
            if (arr[minIndex] > arr[j])
            {
                minIndex = j;
            }
        }
        if (minIndex != i)
        {
            let temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
  
    print("选择排序最终排序结果为:");
    for i in 0..<arr.count {
         print(arr[i], terminator: " ");
    }
}

//调用
//selectionSort(arr: &array)

//插入排序
func insertionSort(arr : inout Array<Int>) {
    for i in 1..<arr.count {
        for j in (1...i).reversed(){
            if(arr[j] < arr[j-1]){
                let temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                arr.swapAt(j, j-1)
            }
        }
    }
    print("\n插入排序最终排序结果为:");
    for i in 0..<arr.count {
        print(arr[i], terminator: " ");
    }
}

//insertionSort(arr: &array)

//希尔排序
func shellSort(arr : inout Array<Int>) -> (Int){
    let N = arr.count;
    var h = 1;
    while h < N/3 {
        h = h * 3 + 1;
    }
    var comparetimes = 0
    while h >= 1 {
        for i in h..<arr.count {
            var j = i
            while(j >= h){
                var exchanged = false
                if(arr[j] < arr[j-h]){
                    arr.swapAt(j, j-h)
                    comparetimes += 1;
                    exchanged = true;
                }
                if(exchanged == false){
                    comparetimes += 1;
                    break
                }
                j -= h;
            }
        }
        h = h/3;
    }
    return comparetimes
}

//shellSort(arr: &array);


/**
 宗旨：先用小数构造最先交换的位置，交换完后，虽然局部有序，但是对于整体来说依然较差
 希尔排序的最坏情况，先使用较小数字 逆向构造间隔最大的位置，类推。
 原因，
1 只构造了已40为 - 797次
 ...
 */

struct Nest{
    var arr : Array<Int>
    var times : Int
}

var nest_group = Array<Nest>()
var nest_new =  Array<Nest>()
var nest_result : Nest
var M = 20 //种群数量


func getWorstArray() -> Array<Int> {
    var array = Array(repeating: 0, count: 100);
    //先逆向构造最靠后的数据，也就是数组最末端
    let N = array.count;
    var h = 1;
    while h < N/3 {
        h = h * 3 + 1;
    }
    var key = 1;
    for i in (1..<array.count).reversed() {
        var j = i
        while(j >= 0){
            if(array[j] == 0){
                array[j] = key
                key += 1
            }
            j -= h
        }
    }
    for i in 0..<array.count {
        print(array[i], terminator: " ");
    }
    return array;
}

func createGroup() {
    
    let N = 100;
    var h = 1;
    while h < N/3 {
        h = h * 3 + 1;
    }
    let tmp = h/M
    while h >= 1  {
        //先逆向构造最靠后的数据，也就是数组最末端
        var array = Array(repeating: 0, count: N);
        var key = 1;
        for i in (1..<array.count).reversed() {
            var j = i
            while(j >= 0){
                if(array[j] == 0){
                    array[j] = key
                    key += 1
                }
                j -= h
            }
        }
        let nest = Nest(arr: array, times: shellSort(arr: &array))
        nest_group.append(nest)
        h -= tmp
    }
}

func sort(arr : inout Array<Nest>){//排序
    var maxIndex : Int //记录最小下标
    for i in 0..<arr.count - 1 {
        maxIndex = i;
        for j in i..<arr.count {
            let nest_j = arr[j]
            let nest_max = arr[maxIndex]
            if (nest_max.times < nest_j.times)
            {
                maxIndex = j;
            }
        }
        if (maxIndex != i)
        {
            let temp = arr[maxIndex];
            arr[maxIndex] = arr[i];
            arr[i] = temp;
        }
    }
    
    print("选择排序最终排序结果为:");
    for i in 0..<arr.count {
        print(arr[i].times, terminator: " ");
    }
}

func levy(p : Int) {
    createGroup()
    sort(arr: &nest_group)
}

func main() {
    createGroup()
    sort(arr: &nest_group)
}

main()
