class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int currCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                maxCount = Math.max(maxCount, currCount);
                currCount = 0;
            } else {
                currCount++;
            }
        }

        return Math.max(maxCount, currCount);
    }
}