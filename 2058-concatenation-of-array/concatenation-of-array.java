class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[nums.length * 2];

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            ans[i] = num;
            ans[i + n] = num;
        }

        return ans;
    }
}