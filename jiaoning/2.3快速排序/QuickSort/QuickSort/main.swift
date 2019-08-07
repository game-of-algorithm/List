//
//  main.swift
//  QuickSort
//
//  Created by JAN on 2019/8/6.
//  Copyright © 2019年 synjones. All rights reserved.
//

import Foundation

var array = [5, 3, 7, 4, 2, 4, 9, 1, 8, 6]

var array1 = [5, 5, 5, 5, 5, 5]
//快速排序
func quickSort(arr: inout Array<Int>, low: Int, high: Int){
    if(low >= high){
        return;
    }
    var i = low + 1;
    var j = high;
    let key = arr[low];
    while true {
        //2.3.17
        //去掉右边界，因为arr最右侧那个数肯定比key大（arr[length-1] > key），所以肯定进不来这个while,也就肯定不用判断if(i == high)
        while (key > arr[i]){
//            if(i == high){
//                break;
//            }
            i += 1;
        }
        while (key < arr[j]){
            //去掉左边界
//            if(j == low){
//                break;
//            }
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
//    quickSort(arr: &arr, low: low, high: j-1)
    quickSort(arr: &arr, low: low, high: j)
    quickSort(arr: &arr, low: j+1, high: high)
}

/**
 2.3.9
 2种主键时，一次分割之后就完成了排序。
 3种主键时，和一般一样
 */


/**
 2.3.15
 1.先选第一个螺帽作为哨兵，通过螺帽逐个在螺丝堆里比较，
 比螺帽小的放在一边，比螺帽大的放另一边，匹配到螺帽的拿出来
 2.然后通过找到的这个螺帽，去螺丝堆里比较
 比这个螺帽小的放在一边，比这个螺帽大的放在另一边，匹配的那个上一步已经有了
 3.这个时候，除了匹配的那一对螺帽和螺丝，各有两堆小螺帽、小螺丝；大螺帽，大螺丝
 4.然后再小对应小，大对应大，分别去重复这个步骤。
 */


/**
 2.3.20
 用栈？
 */
class Stack {
    var array = [Int]();
    
    func pop() -> Int?{
        let index = array.last
        array.removeLast();
        return index
    }
    func push(_ index: Int){
        array.append(index)
    }
    func isEmpty() -> Bool{
        if(array.count == 0){
            return true
        }
        return false
    }
}

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

func QuickSortNonRecursive() {
    let stack = Stack()
    
    stack.push(0);
    stack.push(array.count - 1);
    
    while !stack.isEmpty() {
        let high = stack.pop()!
        let low = stack.pop()!
        
        if(low >= high){
            continue
        }
        let k = quickSortReturnIndex(arr: &array, low: low, high: high)
        let j: Int
        if(k == nil){
            continue
        }
        j = k!
        // 让较大的子数组先入栈（先排序较小的子数组）
        if (j - low > high - j){
            stack.push(low);
            stack.push(j - 1);
            
            stack.push(j + 1);
            stack.push(high);
        }
        else{
            stack.push(j + 1);
            stack.push(high);
            
            stack.push(low);
            stack.push(j - 1);
        }
    }
}

func main() {
/**
 2.3.17
 */
//  先找出最大放在最右边
//    var v = array[0];
//    var index = 0;
//    for i in 1..<array.count {
//        if(array[i] > v){
//            v = array[i];
//            index = i;
//        }
//    }
//    array.swapAt(index, array.count-1)

//    quickSort(arr: &array, low: 0, high: array.count-1)
    
/**
 2.3.20调用方法
 */
//    QuickSortNonRecursive()
    
    
    //log
    for i in array {
        print(i, separator:"", terminator: " ");
    }
}
main()

//https://www.cnblogs.com/longjin2018/p/9868579.html
//https://www.cnblogs.com/ikesnowy/p/9406468.html
