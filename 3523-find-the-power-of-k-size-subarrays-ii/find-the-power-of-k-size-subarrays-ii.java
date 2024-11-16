class Solution {
    public int[] resultsArray(int[] nums, int k) {
        if (k == 1) {
            return nums; // If k is 1, every single element is a valid subarray
        }

        int length = nums.length;
        int[] result = new int[length - k + 1];
        Arrays.fill(result, -1); // Initialize results to -1
        int consecutiveCount = 1; // Count of consecutive elements

        for (int index = 0; index < length - 1; index++) {
            if (nums[index] + 1 == nums[index + 1]) {
                consecutiveCount++;
            } else {
                consecutiveCount = 1; // Reset count if not consecutive
            }

            // If we have enough consecutive elements, update the result
            if (consecutiveCount >= k) {
                result[index - k + 2] = nums[index + 1];
            }
        }

        return result;
    }
}