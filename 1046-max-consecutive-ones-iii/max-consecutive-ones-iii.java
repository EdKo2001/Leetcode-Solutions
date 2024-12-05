class Solution {
    public int longestOnes(int[] nums, int k) {
        int longest = 0;
        int curr = 0;

        int flipCnt = 0;
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0 && flipCnt == k) {
                longest = Math.max(longest, curr);
                while (flipCnt == k) {
                    if (nums[start] == 0)
                        flipCnt--;
                    curr--;
                    start++;
                }
            }
            if (nums[i] == 0)
                flipCnt++;
            curr++;
        }

        return Math.max(longest, curr);
    }
}