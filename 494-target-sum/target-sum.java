class Solution {
 public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // Check if target + totalSum is invalid or not divisible by 2
        if ((target + totalSum) % 2 != 0 || target > totalSum || target < -totalSum) {
            return 0;
        }

        // Calculate the subset sum (P)
        int subsetSum = (target + totalSum) / 2;

        return countSubsets(nums, subsetSum);
    }

    private int countSubsets(int[] nums, int sum) {
        int n = nums.length;
        int[] dp = new int[sum + 1];
        dp[0] = 1; // Base case: one way to achieve a sum of 0 (use no elements)

        // Update dp array for each number in nums
        for (int num : nums) {
            for (int j = sum; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }

        return dp[sum];
    }
}