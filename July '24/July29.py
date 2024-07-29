'''
Q- Count Number of Teams

There are n soldiers standing in a line. Each soldier is assigned a unique rating value.

You have to form a team of 3 soldiers amongst them under the following rules:

Choose 3 soldiers with index (i, j, k) with rating (rating[i], rating[j], rating[k]).
A team is valid if: (rating[i] < rating[j] < rating[k]) or (rating[i] > rating[j] > rating[k]) where (0 <= i < j < k < n).
Return the number of teams you can form given the conditions. (soldiers can be part of multiple teams).

Link - https://leetcode.com/problems/count-number-of-teams/description/

'''

from typing import List

def numTeams(ratings: List[int]) -> int:
    count = 0
    n = len(ratings)

    for i in range(n):
        l_gt, l_lw, r_gt, r_lw = 0,0,0,0
        for j in range(i):
            if ratings[j]<ratings[i]:
                l_lw += 1
            else:
                l_gt += 1
        for j in range(i+1, n):
            if ratings[j]<ratings[i]:
                r_lw += 1
            else:
                r_gt += 1
        count += (r_lw*l_gt)+(r_gt*l_lw)
    return count

if(__name__=='__main__'):
    print("Example 1: [2,5,3,4,1]")
    print(numTeams([2,5,3,4,1]))

    print("Example 2: [2,1,3]")
    print(numTeams([2,1,3]))

    print("Example 3: [1,2,3,4]")
    print(numTeams([1,2,3,4]))