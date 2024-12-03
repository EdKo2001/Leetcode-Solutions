class Solution {
    public int waysToSplitArray(int[] nums) {
        long totalSum = 0;
        int count = 0;

        // Calculate the total sum of the array
        for (int num : nums) {
            totalSum += num;
        }

        long prefixSum = 0;

        // Iterate over the array to check each split point
        for (int i = 0; i < nums.length - 1; i++) {
            prefixSum += nums[i]; // Calculate the prefix sum up to the current point

            if (prefixSum >= totalSum - prefixSum) { // Compare left and right sums
                count++;
            }
        }

        return count;
    }
}
