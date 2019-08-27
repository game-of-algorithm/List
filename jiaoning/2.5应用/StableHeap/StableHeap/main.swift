//
//  main.swift
//  StableHeap
//
//  Created by JAN on 2019/8/27.
//  Copyright © 2019年 synjones. All rights reserved.
//

import Foundation

 var array = [0, 1, 13, 1, 16, 1, 9, 8, 5, 5, 5, 1, 10];
var indexs = [0, 1, 2,  3, 4,  5, 6, 7, 8, 9, 10, 11, 12];


//下沉
func sink(arr: inout Array<Int>, k: Int, N: Int) {
    var i = k
    while 2*i <= N {
        var j = 2*i
        if j < N && arr[j] <= arr[j+1]{
            if arr[j] == arr[j+1]{
                if(indexs[j] > indexs[j+1]){
                    j += 1
                }
            }else{
                j += 1
            }
        }
        if arr[j] >= arr[i]{
            if arr[j] == arr[i] {
                if indexs[j] < indexs[i]{
                    arr.swapAt(i, j)
                    indexs.swapAt(i, j);
                    i = j
                }else{
                    break
                }
            }else{
                arr.swapAt(i, j)
                indexs.swapAt(i, j);
                i = j
            }
        }else{
            break
        }
    }
}
//输出最大值
func getHeapMax(array: inout Array<Int>) -> (value: Int, index: Int) {
    var N = array.count-1
    let max = array[1]
    let index = indexs[1];
    
    array.swapAt(1, N)//交换第一个和最后一个
    indexs.swapAt(1, N) //交换其位置
    
    array.removeLast() //删除最大值
    indexs.removeLast()
    
    N -= 1
    sink(arr: &array, k: 1, N: N) //再次堆化
   
    return (max, index)
}

func main() {
    var N = array.count-1;
    for k in (1...N/2).reversed() {
        sink(arr: &array, k: k, N: N)
    }
    
    for i in 1...N {
        let tuple = getHeapMax(array: &array);
        print(tuple)
    }
}
main()
