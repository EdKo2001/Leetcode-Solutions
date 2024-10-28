class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);

        int max = Math.max(nums[0], nums[1]);
        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = nums[1];

        for (int i = 2; i < nums.length; i++) {
            for (int j = 0; j < i - 1; j++) {
                int curSum = dp[j] + nums[i];
                if (curSum > dp[i]) {
                    dp[i] = curSum;
                    max = Math.max(max, curSum);
                }
            }
        }

        return max;
    }
}