class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int cnt = 0;
        int oddCount = 0;
        int validSubarrayStart = 0; // Pointer to track the first valid subarray start

        int start = 0;
        for (int end = 0; end < nums.length; end++) {
            if (nums[end] % 2 != 0)
                oddCount++;
            while (oddCount > k && start <= end) {
                if (nums[start] % 2 != 0)
                    oddCount--;
                start++;
            }
            if (oddCount == k) {
                validSubarrayStart = start;

                // Move validSubarrayStart to the first position where the subarray
                // still has k odd numbers
                while (nums[validSubarrayStart] % 2 == 0) {
                    validSubarrayStart++;
                }

                // Add all subarrays ending at i and starting from validSubarrayStart
                cnt += (validSubarrayStart - start + 1);
            }
        }

        return cnt;
    }
}