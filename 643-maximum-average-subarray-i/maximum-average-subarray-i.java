class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double maxSum = 0;
        double curWindowSum = 0;

        for (int i = 0; i < k; i++) {
            curWindowSum += nums[i];
        }

        maxSum = curWindowSum;

        for (int i = k; i < nums.length; i++) {
            curWindowSum -= nums[i - k];
            curWindowSum += nums[i];
            maxSum = Math.max(maxSum, curWindowSum);
        }

        return maxSum / k;
    }
}