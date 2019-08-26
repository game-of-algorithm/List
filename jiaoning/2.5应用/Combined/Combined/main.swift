//
//  main.swift
//  Combined
//
//  Created by JAN on 2019/8/26.
//  Copyright © 2019年 synjones. All rights reserved.
//

import Foundation

//下沉
func sink(arr: inout Array<Processor>, k: Int, N: Int)  {
    var i = k
    while 2*i <= N {
        var j = 2*i
        
        if j < N && arr[j].totalTime > arr[j+1].totalTime{
            j += 1
        }
        if arr[j].totalTime < arr[i].totalTime{
            arr.swapAt(i, j)
            i = j
        }else{
            break
        }
    }
}

//上浮
func swim(arr: inout Array<Processor>, k: Int) {
    var i = k
    while i > 1 && arr[i].totalTime < arr[i/2].totalTime {
        arr.swapAt(i, i/2)
        i = i/2
    }
}

//堆排序
func heapSort(arr: inout Array<Processor>) {
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

//2.5.13负载均衡
class Job {
    let name: String
    let time: Int
    init(name:String, time: Int) {
        self.name = name
        self.time = time
    }
}

class Processor {
    var array : Array<Job>
    var totalTime = 0
    init() {
        array = [Job]()
    }
    func add(job: Job) {
        array.append(job)
        totalTime += job.time;
    }
}

class Queue {
    let M = 4;
    var array : Array<Processor>
    init() {
        array = [Processor]()
        //下标0不用
        for _ in 0 ... M {
            array.append(Processor())
        }
    }
    //删除最小优先级的
    func deleteMin() -> Processor? {
        let p = array[1]
        array.remove(at: 1);
        return p
    }
    //插入
    func insert(p: Processor) {
        array.append(p);
        swim(arr: &array, k: M)
    }
}

func main() {
    var jobs = [Job]();
    jobs.append(Job(name: "1", time: 30))
    jobs.append(Job(name: "2", time: 27))
    jobs.append(Job(name: "3", time: 25))
    jobs.append(Job(name: "4", time: 24))
    jobs.append(Job(name: "5", time: 23))
    jobs.append(Job(name: "6", time: 17))
    jobs.append(Job(name: "7", time: 15))
    jobs.append(Job(name: "8", time: 12))
    jobs.append(Job(name: "9", time: 10))
    jobs.append(Job(name: "1", time: 9))
    jobs.append(Job(name: "11", time: 7))
    jobs.append(Job(name: "12", time: 6))
    jobs.append(Job(name: "13", time: 5))
    jobs.append(Job(name: "14", time: 4))
    jobs.append(Job(name: "15", time: 1))
    
    let queue = Queue.init()
    for job in jobs {
        let processor = queue.deleteMin()!
        //向其中加入任务
        processor.add(job: job)
        //把处理器加入到优先队列
        queue.insert(p: processor);
    }
    //输出
    for p in queue.array {
        print("Processor Total: \(p.totalTime)")
        for job in p.array{
            print("name:\(job.name) time:\(job.time)")
        }
    }
}

main()



