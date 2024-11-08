class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int xorProduct = 0;
        for (int i = 0; i < nums.length; i++) {
            xorProduct = xorProduct ^ nums[i];
        }
        int[] ans = new int[nums.length];

        int mask = (1 << maximumBit) - 1;

        for (int i = 0; i < nums.length; i++) {
            ans[i] = xorProduct ^ mask;
            // remove last element
            xorProduct = xorProduct ^ nums[nums.length - 1 - i];
        }

        return ans;
    }
}