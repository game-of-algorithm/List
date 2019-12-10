//
//  main.swift
//  leetcode743
//
//  Created by JAN on 2019/12/9.
//  Copyright © 2019 synjones. All rights reserved.
//

import Foundation
//Map<Integer, List<int[]>> graph = new HashMap();
//for (int[] edge: times) {
//    if (!graph.containsKey(edge[0]))
//    graph.put(edge[0], new ArrayList<int[]>());
//    graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
//}
//dist = new HashMap();
//for (int node = 1; node <= N; ++node)
//dist.put(node, Integer.MAX_VALUE);
//
//dist.put(K, 0);
//boolean[] seen = new boolean[N+1];
//
//while (true) {
//    int candNode = -1;
//    int candDist = Integer.MAX_VALUE;
//    for (int i = 1; i <= N; ++i) {
//        if (!seen[i] && dist.get(i) < candDist) {
//            candDist = dist.get(i);
//            candNode = i;
//        }
//    }
//
//    if (candNode < 0) break;
//    seen[candNode] = true;
//    if (graph.containsKey(candNode))
//    for (int[] info: graph.get(candNode))
//        dist.put(info[0],
//                 Math.min(dist.get(info[0]), dist.get(candNode) + info[1]));
//}
//
//int ans = 0;
//for (int cand: dist.values()) {
//    if (cand == Integer.MAX_VALUE) return -1;
//    ans = Math.max(ans, cand);
//}
//return ans;

func networkDelayTime(_ times: [[Int]], _ N: Int, _ K: Int) -> Int {
    //构造图
    var graph = Dictionary<Int, [[Int]]>()
    for edge in times{
        let key = edge[0]
        if !graph.keys.contains(key) {
            graph[key] = [[Int]]()
        }
        graph[key]?.append([edge[1], edge[2]])
    }
    //构造dist,初始化为无穷大
    var dist = Dictionary<Int, Int>()
    for node in 1...N {
        dist[node] = Int.max
    }
    //K点到自己的距离为0
    dist[K] = 0;
    var seen = Array<Bool>(repeating: false, count: N+1)
    while true {
        //candidate 候选人，这里候选node
        var candNode = -1
        var candDist = Int.max
        for i in 1...N {
            if (!seen[i] && dist[i]! < candDist) {
                candDist = dist[i]!
                candNode = i
            }
        }
        //如果找不到可达顶点 break
        if candNode < 0 {
            break
        }
        
        seen[candNode] = true
        if graph.keys.contains(candNode) {
            for info in graph[candNode]! {
                dist[info[0]] = min(dist[info[0]]!, dist[candNode]! + info[1])
            }
        }
    }
    var ans = 0
    for cand in dist.values {
        if cand == Int.max {
            return -1
        }
        ans = max(ans, cand)
    }
    return ans;
}

func main() {
    var times = [[2,1,1],[2,3,1],[3,4,1]]
    networkDelayTime(times, 4, 2)
}

main()

