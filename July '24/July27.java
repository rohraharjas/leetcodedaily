/**
 * Q- Minimum cost to convert string
 * 
 * You are given two 0-indexed strings source and target, both of length n and consisting of lowercase English letters. You are also given two 0-indexed character arrays original and changed, and an integer array cost, where cost[i] represents the cost of changing the character original[i] to the character changed[i].

You start with the string source. In one operation, you can pick a character x from the string and change it to the character y at a cost of z if there exists any index j such that cost[j] == z, original[j] == x, and changed[j] == y.

Return the minimum cost to convert the string source to the string target using any number of operations. If it is impossible to convert source to target, return -1.

Note that there may exist indices i, j such that original[j] == original[i] and changed[j] == changed[i].

Link - https://leetcode.com/problems/minimum-cost-to-convert-string-i/description/
 */

import java.util.*;
class Solution{
    //Defining constants used in the program
    private static final int CHAR_COUNT = 26;
    private static final int INF = Integer.MAX_VALUE / 2;

    //Function to generate minimum cost
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int[][] conversionGraph = buildConversionGraph(original, changed, cost);
        optimizeConversionPaths(conversionGraph);
        return computeTotalConversionCost(source, target, conversionGraph);
    }

    //Generates conversion graph
    private int[][] buildConversionGraph(char[] original, char[] changed, int[] cost) {
        int[][] graph = new int[CHAR_COUNT][CHAR_COUNT];
        //Fill graph with infinity
        for (int[] row : graph) {
            Arrays.fill(row, INF);
        }
        //Diagonal values to 0
        for (int i = 0; i < CHAR_COUNT; i++) {
            graph[i][i] = 0;
        }
        //set edge values
        for (int i = 0; i < cost.length; i++) {
            int from = original[i] - 'a';
            int to = changed[i] - 'a';
            graph[from][to] = Math.min(graph[from][to], cost[i]);
        }
        return graph;
    }

    //Optimise graph path using Floyd-Warshall algorithm
    private void optimizeConversionPaths(int[][] graph) {
        for (int k = 0; k < CHAR_COUNT; k++) {
            for (int i = 0; i < CHAR_COUNT; i++) {
                if (graph[i][k] < INF) {
                    for (int j = 0; j < CHAR_COUNT; j++) {
                        if (graph[k][j] < INF) {
                            graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                        }
                    }
                }
            }
        }
    }

    //Computes final cost
    private long computeTotalConversionCost(String source, String target, int[][] graph) {
        long totalCost = 0;
        for (int i = 0; i < source.length(); i++) {
            int sourceChar = source.charAt(i) - 'a';
            int targetChar = target.charAt(i) - 'a';
            if (sourceChar != targetChar) {
                if (graph[sourceChar][targetChar] == INF) {
                    return -1L;
                }
                totalCost += graph[sourceChar][targetChar];
            }
        }
        return totalCost;
    }
    public static void main(String[] args) {
        //Example 1
        String source = "aaaa", target = "bbbb";
        char[] original = {'a','c'}, changed = {'c','b'};
        int[] cost = {1,2};
        Solution obj = new Solution();

        System.out.println("Example 1: "+obj.minimumCost(source, target, original, changed, cost));

        //Example 2
        source = "abcd";
        target = "abce";
        char[] original2 = {'a'};
        char[] changed2 = {'e'};
        int[] cost2 = {10000};

        System.out.println("Example 2: "+obj.minimumCost(source, target, original2, changed2, cost2));
    }
}