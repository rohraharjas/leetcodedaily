# Q- Sort an array
# Given an array of integers nums, sort the array in ascending order and return it.
# You must solve the problem without using any built-in functions in O(nlog(n)) time complexity and with the smallest space complexity possible.

# link - https://leetcode.com/problems/sort-an-array/description/

#Solution
def sortArray(nums):
        #Merge Sort function
        def merge_sort(arr):
            #base case to check whether further division is possible
            if len(arr) > 1:
                #find mid and split
                mid = len(arr) // 2
                left_half = arr[:mid]
                right_half = arr[mid:]

                #recursive calls for both halves
                merge_sort(left_half)
                merge_sort(right_half)

                #merging both sub arrays
                i = j = k = 0
                while i < len(left_half) and j < len(right_half):
                    if left_half[i] < right_half[j]:
                        arr[k] = left_half[i]
                        i += 1
                    else:
                        arr[k] = right_half[j]
                        j += 1
                    k += 1

                while i < len(left_half):
                    arr[k] = left_half[i]
                    i += 1
                    k += 1

                while j < len(right_half):
                    arr[k] = right_half[j]
                    j += 1
                    k += 1

        merge_sort(nums)
        return nums


#Example 
if __name__ == '__main__':
    print("Sort Array1 [5,2,3,1]")
    nums1 = [5,2,3,1]
    print(sortArray(nums1))
    print("Sort Array2 [5,1,1,2,0,0]")
    nums2 = [5,1,1,2,0,0]
    print(sortArray(nums2))