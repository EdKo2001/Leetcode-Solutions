class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long maxSum = 0; // Stores the maximum subarray sum
        long currentSum = 0; // Stores the current window's sum
        HashSet<Integer> set = new HashSet<>(); // Tracks unique elements in the window

        int start = 0; // Left pointer of the window

        for (int end = 0; end < nums.length; end++) {
            // Shrink the window if the current element is already in the set
            while (set.contains(nums[end])) {
                set.remove(nums[start]);
                currentSum -= nums[start];
                start++;
            }

            // Add the current element to the window
            set.add(nums[end]);
            currentSum += nums[end];

            // Check if the window size is exactly k
            if (end - start + 1 == k) {
                maxSum = Math.max(maxSum, currentSum);

                // Slide the window by removing the leftmost element
                set.remove(nums[start]);
                currentSum -= nums[start];
                start++;
            }
        }

        return maxSum;
    }
}
