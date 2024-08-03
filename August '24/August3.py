from typing import List
def canBeEqual(target: List[int], arr: List[int]) -> bool:
        target.sort()
        arr.sort()
        for i in range(len(arr)):
            if arr[i] != target[i]:
                return False
        return True

if __name__ == '__main__':
    print("Example 1: target = [1,2,3,4], arr = [2,4,1,3]")
    print(canBeEqual([1,2,3,4], [2,4,1,3]))

    print("Example 2: target = [7], arr = [7]")
    print(canBeEqual([7], [7]))

    print("Example 3: target = [3,7,9], arr = [3,7,11]")
    print(canBeEqual([3,7,9], [3,7,11]))