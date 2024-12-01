class Solution {
    public int removeElement(int[] nums, int val) {
        int toBeChanged = 0;

        for (int num : nums) {
            if (num != val) {
                nums[toBeChanged++] = num;
            }
        }

        return toBeChanged;
    }
}