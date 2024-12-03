class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];

        int left = 0;
        int right = nums.length - 1;
        int resIndex = 0;

        while (left <= right) {
            int leftNum = nums[left] * nums[left];
            int rightNum = nums[right] * nums[right];
            if (leftNum > rightNum) {
                res[resIndex++] = leftNum;
                left++;
            } else {
                res[resIndex++] = rightNum;
                right--;
            }
        }

        int[] ans = new int[res.length];
        for (int i = 0; i < res.length; i++) {
            ans[i] = res[res.length - 1 - i];
        }

        return ans;
    }
}