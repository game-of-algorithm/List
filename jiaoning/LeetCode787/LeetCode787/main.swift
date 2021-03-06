//
//  main.swift
//  LeetCode787
//
//  Created by JAN on 2019/12/10.
//  Copyright © 2019 synjones. All rights reserved.
//

import Foundation

//public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
//    int[][] dist = new int[2][n];
//    int INF = Integer.MAX_VALUE / 2;
//    Arrays.fill(dist[0], INF);
//    Arrays.fill(dist[1], INF);
//    dist[0][src] = dist[1][src] = 0;
//
//    for (int i = 0; i <= K; ++i)
//    for (int[] edge: flights)
//        dist[i&1][edge[1]] = Math.min(dist[i&1][edge[1]], dist[~i&1][edge[0]] + edge[2]);
//
//    return dist[K&1][dst] < INF ? dist[K&1][dst] : -1;
//}
//

func findCheapestPrice(_ n: Int, _ flights: [[Int]], _ src: Int, _ dst: Int, _ K: Int) -> Int {
    var dist = [[Int]]()
    let max = Int.max / 2
    dist.append(Array.init(repeating: max, count: n))
    dist.append(Array.init(repeating: max, count: n))
    dist[0][src] = 0
    dist[1][src] = 0
    for i in 0...K {
        for edge in flights {
            dist[i&1][edge[1]] = min(dist[i&1][edge[1]], dist[~i&1][edge[0]] + edge[2])
        }
    }
    return dist[K&1][dst] < max ? dist[K&1][dst] : -1
}

func main() {
    
}



//第二种
//class Solution {
//    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
//    int[][] graph = new int[n][n];
//    for (int[] flight: flights)
//    graph[flight[0]][flight[1]] = flight[2];
//
//    Map<Integer, Integer> best = new HashMap();
//
//    PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
//    pq.offer(new int[]{0, 0, src});
//
//    while (!pq.isEmpty()) {
//    int[] info = pq.poll();
//    int cost = info[0], k = info[1], place = info[2];
//    if (k > K+1 || cost > best.getOrDefault(k * 1000 + place, Integer.MAX_VALUE))
//    continue;
//    if (place == dst)
//    return cost;
//
//    for (int nei = 0; nei < n; ++nei) if (graph[place][nei] > 0) {
//    int newcost = cost + graph[place][nei];
//    if (newcost < best.getOrDefault((k+1) * 1000 + nei, Integer.MAX_VALUE)) {
//    pq.offer(new int[]{newcost, k+1, nei});
//    best.put((k+1) * 1000 + nei, newcost);
//    }
//    }
//    }
//
//    return -1;
//    }
//}
