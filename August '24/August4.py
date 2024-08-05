from typing import List
def rangeSum(nums: List[int], n: int, left: int, right: int) -> int:
        subarray_sums = []

        # Compute all subarray sums
        for i in range(n):
            current_sum = 0
            for j in range(i, n):
                current_sum += nums[j]
                subarray_sums.append(current_sum)
        
        # Sort the subarray sums
        subarray_sums.sort()
        
        # Compute the sum from index left to right (1-indexed)
        mod = 10**9 + 7
        result_sum = sum(subarray_sums[left-1:right]) % mod
        
        return result_sum

if __name__ == '__main__':
    print("Example 1: nums = [1,2,3,4], n = 4, left = 1, right = 5")
    print(rangeSum([1,2,3,4], 4, 1, 5))

    print("Example 2: nums = [1,2,3,4], n = 4, left = 3, right = 4")
    print(rangeSum([1,2,3,4], 4, 3, 4))

    print("Example 3: nums = [1,2,3,4], n = 4, left = 1, right = 10")
    print(rangeSum([1,2,3,4], 4, 1, 10))