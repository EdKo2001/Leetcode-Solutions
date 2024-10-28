class Solution {
    public void sortColors(int[] nums) {
        int redIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                swap(nums, redIdx++, i);
            }
        }

        int whiteIdx = redIdx;
        for (int i = redIdx; i < nums.length; i++) {
            if (nums[i] == 1) {
                swap(nums, whiteIdx++, i);
            }
        }
    }

    public static void swap(int[] nums, int idx1, int idx2) {
        int tmp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = tmp;
    }
}
