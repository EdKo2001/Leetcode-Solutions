class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0)
            return 0; // Handle empty input

        int maxPrd = nums[0]; // Start with the first element
        int curMax = nums[0]; // Max product ending at the current position
        int curMin = nums[0]; // Min product ending at the current position

        for (int i = 1; i < nums.length; i++) {
            // If current number is negative, swap curMax and curMin
            if (nums[i] < 0) {
                int temp = curMax;
                curMax = curMin;
                curMin = temp;
            }

            // Calculate the max and min products up to the current index
            curMax = Math.max(nums[i], curMax * nums[i]);
            curMin = Math.min(nums[i], curMin * nums[i]);

            // Update the overall maximum product
            maxPrd = Math.max(maxPrd, curMax);
        }

        return maxPrd;
    }
}
