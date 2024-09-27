class Solution {
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;

        // Move the `right` pointer to skip elements equal to `val` from the end
        while (right >= 0 && nums[right] == val) {
            right--;
        }

        // Iterate over the array and replace elements if necessary
        while (left <= right) {
            if (nums[left] == val) {
                nums[left] = nums[right];
                right--; // Decrease the right pointer since it's replaced
                while (right >= 0 && nums[right] == val) {
                    right--; // Continue skipping elements equal to `val` from the end
                }
            }
            left++;
        }

        // Return the number of valid elements
        return right + 1;
    }
}
