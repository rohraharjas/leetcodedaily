# Q- Find the City With the Smallest Number of Neighbors at a Threshold Distance

# There are n cities numbered from 0 to n-1. Given the array edges where edges[i] = [fromi, toi, weighti] represents a bidirectional and weighted edge between cities fromi and toi, and given the integer distanceThreshold.

# Return the city with the smallest number of cities that are reachable through some path and whose distance is at most distanceThreshold, If there are multiple such cities, return the city with the greatest number.

# Notice that the distance of a path connecting cities i and j is equal to the sum of the edges' weights along that path.

# Link - https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/description/

from typing import List
#Solution
def findTheCity(n: int, edges: List[List[int]], d: int) -> int:
        #create a distance matrix and set all values to infinity
        dist = [[10001]*n for i in range(n)]
        #set diagonal values to 0 as distance to same node is 0
        for i in range(n):
            dist[i][i] = 0
        #initialise distance between given edges with edge weights
        for edge in edges:
            dist[edge[0]][edge[1]] = edge[2]
            dist[edge[1]][edge[0]] = edge[2]
        
        #floyd-warshalls algorithm
        for i in range(n):
            for j in range(n):
                for k in range(n):
                    #if sum of distances for j->i and i->k is less than distance between j->k reset distance between j->k
                    #i is an intermediary node to find shortest distance
                    if dist[j][i]+dist[i][k]<dist[j][k]:
                        dist[j][k] = dist[j][i] + dist[k][i]
        
        ret = -1
        minCit = n

        #search for node with least possible valid paths
        for i in range(n):
            count = 0
            for j in range(n):
                if dist[i][j]<=d:
                    count += 1
            if count<=minCit:
                minCit = count
                ret = i
        return ret,minCit

if __name__ == '__main__':
    edges = [[0,1,3],[1,2,1],[1,3,4],[2,3,1]]
    n = 4
    d = 4

    ans, num = findTheCity(n, edges, d)

    print(ans, " ", num)