/**
 * Q- Second Minimum Time to Reach Destination
 * 
 * A city is represented as a bi-directional connected graph with n vertices where each vertex is labeled from 1 to n (inclusive). The edges in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi] denotes a bi-directional edge between vertex ui and vertex vi. Every vertex pair is connected by at most one edge, and no vertex has an edge to itself. The time taken to traverse any edge is time minutes.

Each vertex has a traffic signal which changes its color from green to red and vice versa every change minutes. All signals change at the same time. You can enter a vertex at any time, but can leave a vertex only when the signal is green. You cannot wait at a vertex if the signal is green.

The second minimum value is defined as the smallest value strictly larger than the minimum value.

For example the second minimum value of [2, 3, 4] is 3, and the second minimum value of [2, 2, 4] is 4.
Given n, edges, time, and change, return the second minimum time it will take to go from vertex 1 to vertex n.

Notes:

You can go through any vertex any number of times, including 1 and n.
You can assume that when the journey starts, all signals have just turned green.

Link - https://leetcode.com/problems/second-minimum-time-to-reach-destination/description
 */

import java.util.*;

class Solution{
    public int secondMinTime(int n, int[][] edges, int time, int change){
        //Creating Adjacency List for Graph
        ArrayList<Integer>[] adj = new ArrayList[n+1];
        for(int i=0;i<n;i++){
            adj[i] = new ArrayList<>();
        }

        for(int[] edge: edges){
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        //Each entry in pq is [currTime, currNode, pathCount]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.offer(new int[]{0,1,0});

        // To store the shortest and second shortest time to each vertex
        int[] firstTime = new int[n + 1];
        int[] secondTime = new int[n + 1];
        Arrays.fill(firstTime, Integer.MAX_VALUE);
        Arrays.fill(secondTime, Integer.MAX_VALUE);

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int currTime = curr[0];
            int currNode = curr[1];

            //Handle wait time
            int waitTime = 0;
            if((currTime/change)%2 == 1){
                waitTime = change - (currTime%change);
            }
            int arrivalTime = currTime + waitTime + time;
            //Add neighbors to pq
            for(int neighbor:adj[currNode]){
                if(arrivalTime<firstTime[neighbor]){
                    secondTime[neighbor] = firstTime[neighbor];
                    firstTime[neighbor] = arrivalTime;
                    pq.offer(new int[]{firstTime[neighbor], neighbor});
                }
                else if(arrivalTime>firstTime[neighbor] && arrivalTime<secondTime[neighbor]){
                    secondTime[neighbor] = arrivalTime;
                    pq.offer(new int[]{secondTime[neighbor], neighbor});
                }
            }
        }
        return secondTime[n];
    }

    public static void main(String[] args) {
        Solution obj = new Solution();

        System.out.println("Example 1 n = 5, edges = [[1,2],[1,3],[1,4],[3,4],[4,5]], time = 3, change = 5");
        int[][] edges = {{1, 2}, {1, 3}, {1, 4}, {3, 4}, {4, 5}};
        int time = 3;
        int change = 5;
        System.out.println(obj.secondMinTime(5, edges, time, change));

        System.out.println("Example 2 n = 2, edges = [[1,2]], time = 3, change = 2");
        int[][] edges2 = {{1,2}};
        change = 2;
        System.out.println(obj.secondMinTime(2, edges2, time, change));
    }
}