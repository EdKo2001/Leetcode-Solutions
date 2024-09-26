class Solution {
    public int[] runningSum(int[] nums) {
        int[] res = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                res[0] = nums[i];
            } else {
                res[i] = res[i - 1] + nums[i];
            }
        }

        return res;
    }
}