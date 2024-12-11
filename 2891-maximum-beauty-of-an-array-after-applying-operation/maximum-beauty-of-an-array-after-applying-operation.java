class Solution {

    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int maxBeauty = 0;

        for (int i = 0; i < nums.length; i++) {
            // Find the farthest index where the value is within the range [nums[i], nums[i]
            // + 2*k]
            int upperBound = findUpperBound(nums, nums[i] + 2 * k);
            // Update the maximum beauty based on the current range
            maxBeauty = Math.max(maxBeauty, upperBound - i + 1);
        }
        return maxBeauty;
    }

    // Helper function to find the largest index where arr[index] <= val
    private int findUpperBound(int[] arr, int val) {
        int low = 0, high = arr.length - 1, result = 0;

        // Perform binary search to find the upper bound
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= val) {
                result = mid; // Update the result and move to the right half
                low = mid + 1;
            } else {
                high = mid - 1; // Move to the left half
            }
        }
        return result;
    }
}