class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            // Check if mid is even or odd
            if (mid % 2 == 0) {
                // If mid is even, pair lies on the right
                if (nums[mid] == nums[mid + 1]) {
                    low = mid + 2; // Ignore the right half
                } else {
                    high = mid; // The single element is on the left half
                }
            } else {
                // If mid is odd, pair lies on the left
                if (nums[mid] == nums[mid - 1]) {
                    low = mid + 1; // Ignore the left half
                } else {
                    high = mid; // The single element is on the right half
                }
            }
        }

        return nums[low]; // or nums[high], both will point to the single element
    }
}