class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        // If the array is not rotated
        if (nums[left] <= nums[right]) {
            return nums[left];
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If mid element is greater than right, minimum must be on the right side
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                // Minimum must be on the left side, including mid
                right = mid;
            }
        }

        // After the loop, left == right, which is the index of the minimum
        return nums[left];
    }
}
