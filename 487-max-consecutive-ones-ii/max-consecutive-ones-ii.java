class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int left = 0; // Start of the current window
        int right = 0; // End of the current window
        int zeroCount = 0; // Count of zeros in the current window
        int maxCount = 0; // Maximum length of consecutive 1's with at most one zero flipped

        while (right < nums.length) {
            if (nums[right] == 0) {
                zeroCount++;
            }

            // If we have more than one zero in the window, move the left pointer
            while (zeroCount > 1) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            // Calculate the length of the current window
            maxCount = Math.max(maxCount, right - left + 1);
            right++;
        }

        return maxCount;
    }
}
