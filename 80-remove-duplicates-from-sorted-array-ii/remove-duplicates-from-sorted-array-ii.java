class Solution {
    public int removeDuplicates(int[] nums) {
        int numIndex = 1;
        boolean seen = false;
        for (int i = 1; i < nums.length; i++) {
            if (!seen && nums[i] == nums[i - 1]) {
                seen = true;
                nums[numIndex++] = nums[i];
            }
            if (nums[i] != nums[i - 1]) {
                seen = false;
                nums[numIndex++] = nums[i];
            }
        }
        return numIndex;
    }
}