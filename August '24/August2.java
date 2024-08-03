public class MinSwapsToGroupOnes {
    
    public int minSwaps(int[] nums) {
        int ones = 0;

        // Count the number of 1's in the array
        for (int value : nums) {
            ones += value;
        }

        int n = nums.length;
        int[] sumArray = new int[(n << 1) + 1];

        // Create the prefix sum array for the circular array
        for (int i = 0; i < (n << 1); i++) {
            sumArray[i + 1] = sumArray[i] + nums[i % n];
        }

        int max = 0;

        // Find the maximum sum of subarrays of length 'ones' using sliding window
        for (int i = 0; i < (n << 1); i++) {
            int sliding = i + ones - 1;
            if (sliding < (n << 1)) {
                max = Math.max(max, sumArray[sliding + 1] - sumArray[i]);
            }
        }

        // The minimum number of changes required to make all elements 1
        return ones - max;
    }

    public static void main(String[] args) {
        MinSwapsToGroupOnes solution = new MinSwapsToGroupOnes();

        int[] example1 = {0, 1, 0, 1, 1, 0, 0};
        System.out.println(solution.minSwaps(example1)); // Output: 1

        int[] example2 = {0, 1, 1, 1, 0, 0, 1, 1, 0};
        System.out.println(solution.minSwaps(example2)); // Output: 2

        int[] example3 = {1, 1, 0, 0, 1};
        System.out.println(solution.minSwaps(example3)); // Output: 0
    }
}
