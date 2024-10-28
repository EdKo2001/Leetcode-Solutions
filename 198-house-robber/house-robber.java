class Solution {
    // Solutin #1 (Brute Force)
    // Time Complexity: O(n^2)
    // Spae Complexity: O(n)
    // public int rob(int[] nums) {
    //     int N = nums.length;
    //     if (N == 1)
    //         return nums[0];
    //     if (N == 2)
    //         return Math.max(nums[0], nums[1]);

    //     int max = Math.max(nums[0], nums[1]);
    //     int[] dp = new int[N];

    //     dp[0] = nums[0];
    //     dp[1] = nums[1];

    //     for (int i = 2; i < N; i++) {
    //         for (int j = 0; j < i - 1; j++) {
    //             int curSum = dp[j] + nums[i];
    //             if (curSum > dp[i]) {
    //                 dp[i] = curSum;
    //                 max = Math.max(max, curSum);
    //             }
    //         }
    //     }

    //     return max;
    // }


    // Solutin #2 (Optimized Dynamic Programming)
    // Time Complexity: O(n)
    // Spae Complexity: O(1)
    public int rob(int[] nums) {
        int N = nums.length;

        // Special handling for empty array case.
        if (N == 0) {
            return 0;
        }

        int robNext, robNextPlusOne;

        // Base case initializations.
        robNextPlusOne = 0;
        robNext = nums[N - 1];

        // DP table calculations. Note: we are not using any
        // table here for storing values. Just using two
        // variables will suffice.
        for (int i = N - 2; i >= 0; --i) {
            // Same as the recursive solution.
            int current = Math.max(robNext, robNextPlusOne + nums[i]);

            // Update the variables
            robNextPlusOne = robNext;
            robNext = current;
        }

        return robNext;
    }
}