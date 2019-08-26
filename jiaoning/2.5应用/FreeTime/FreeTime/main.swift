//
//  main.swift
//  FreeTime
//
//  Created by JAN on 2019/8/26.
//  Copyright © 2019年 synjones. All rights reserved.
//

import Foundation


class Task {
    var startTime = 0
    var endTime = 0
    init(startTime: Int, endTime: Int) {
        self.startTime = startTime
        self.endTime = endTime
    }
}

class Stack {
    var array: Array<Int>
    init() {
        array = [Int]()
    }
    func isEmpty() -> Bool {
        return array.count == 0
    }
    
    func push(time: Int) {
        array.append(time)
    }
    
    func pop() {
        array.removeLast();
    }
    
    func top() -> Int {
        return array.last!
    }
}

//下沉 比较绝对值
func sink(arr: inout Array<Int>, k: Int, N: Int) {
    var i = k
    while 2*i <= N {
        var j = 2*i
        if j < N && abs(arr[j]) < abs(arr[j+1]) {
            j += 1
        }
        if abs(arr[j]) > abs(arr[i]){
            arr.swapAt(i, j)
            i = j
        }else{
            break
        }
    }
}

//堆排序
func heapSort(arr: inout Array<Int>) {
    var N = arr.count-1
    for k in (1...N/2).reversed() {
        sink(arr: &arr, k: k, N: N)
    }
    while N > 1 {
        arr.swapAt(1, N);
        N -= 1
        sink(arr: &arr, k: 1, N: N)
    }
}

func sort(tasks: Array<Task>) -> Array<Int> {
    var timeArray = [Int]()
    for task in tasks {
        timeArray.append(task.startTime)
        timeArray.append(-task.endTime)
    }
    heapSort(arr: &timeArray)
    print(timeArray);
    return timeArray
}

func main() {
    var tasks = [Task]()
    tasks.append(Task.init(startTime: 2, endTime:6))
    tasks.append(Task.init(startTime: 4, endTime: 8))
    tasks.append(Task.init(startTime: 10, endTime: 15))
    tasks.append(Task.init(startTime: 20, endTime: 25))
    tasks.append(Task.init(startTime: 22, endTime: 24))
    tasks.append(Task.init(startTime: 35, endTime: 44))
    tasks.append(Task.init(startTime: 43, endTime: 46))
    tasks.append(Task.init(startTime: 50, endTime: 55))
    tasks.append(Task.init(startTime: 53, endTime: 67))
    tasks.append(Task.init(startTime: 60, endTime: 80))
    
    let timeArray = sort(tasks: tasks)
    let stack = Stack.init()
    
    var markTime = 0 //记录第一个进入的时间或者最后一个出栈的时间
    var maxFree = 0
    var maxBusy = 0
    for time in timeArray {
        if time > 0{
            if(stack.isEmpty()){
                maxFree = max(maxFree, time-markTime)
                markTime = time;
            }
            stack.push(time: time)
        }else{
            let topTime = stack.top()
            stack.pop()
            if stack.isEmpty(){
                maxBusy = max(maxBusy, (abs(time) - topTime));
                markTime = abs(time);
            }
        }
    }
    print("最大空闲时间：\(maxFree) ，最大忙碌时间：\(maxBusy)")
}

main()
