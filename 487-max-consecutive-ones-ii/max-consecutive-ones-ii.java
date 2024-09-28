class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int start = 0;
        int maxNumber = 0;
        int countIndex = -1;

        for (int end = 0; end < nums.length; end++) {
            if (nums[end] == 0) {
                if (countIndex != -1) {
                    start = countIndex + 1;
                }
                countIndex = end;
            }
            maxNumber = Math.max(maxNumber, end - start + 1);
        }

        return maxNumber;
    }
}