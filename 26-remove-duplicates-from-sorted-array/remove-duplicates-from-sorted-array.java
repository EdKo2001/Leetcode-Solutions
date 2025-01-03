class Solution {
    public int removeDuplicates(int[] nums) {
        int numIndex = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[numIndex++] = nums[i];
            }
        }
        return numIndex;
    }
}