'''
Q - Kth Distinct String in Array

A distinct string is a string that is present only once in an array.

Given an array of strings arr, and an integer k, return the kth distinct string present in arr. If there are fewer than k distinct strings, return an empty string "".

Note that the strings are considered in the order in which they appear in the array.


Link - https://leetcode.com/problems/kth-distinct-string-in-an-array/description/
'''

from typing import List
def kthDistinct(arr: List[str], k: int) -> str:
        m = {}
        for i in arr:
            m[i] = m.get(i,0)+1
        for i in arr:
            if m[i] == 1:
                if k == 1:
                    return i
                else:
                    k -= 1
        return ""

if __name__ == '__main__':
    print('Example 1: arr = ["d","b","c","b","c","a"], k = 2')
    print(kthDistinct(["d","b","c","b","c","a"], 2))

    print('Example 2: arr = ["aaa","aa","a"], k = 1')
    print(kthDistinct(["aaa","aa","a"], 1))

    print('Example 3: arr = ["a","b","a"], k = 3')
    print(kthDistinct(["a","b","a"], 3))