class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Update the current sum to either the current element itself
            // or the sum of the current element and current sum
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            // Update maxSum if the current sum is greater
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
