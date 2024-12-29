class Solution {

    public int maxSumAfterOperation(int[] nums) {
        int n = nums.length; // Get the size of the input array.

        // Initialize a DP table
        int[][] dp = new int[n][2];

        // Base case
        dp[0][0] = nums[0]; // Maximum sum with no squared element is just the first element.
        dp[0][1] = nums[0] * nums[0]; // Maximum sum with the first element squared.

        int maxSum = dp[0][1];

        for (int index = 1; index < n; index++) {
            // Option 1: Start a new subarray.
            // Option 2: Continue the previous subarray.
            dp[index][0] = Math.max(
                nums[index],
                dp[index - 1][0] + nums[index]
            );

            // Option 1: Start a new subarray.
            // Option 2: Square the current element.
            // Option 3: Do not square the element.
            dp[index][1] = Math.max(
                Math.max(
                    nums[index] * nums[index],
                    dp[index - 1][0] + nums[index] * nums[index]
                ),
                dp[index - 1][1] + nums[index]
            );

            // Update maxSum
            maxSum = Math.max(maxSum, dp[index][1]);
        }

        return maxSum;
    }
}