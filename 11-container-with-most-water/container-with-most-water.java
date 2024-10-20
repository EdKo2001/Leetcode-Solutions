class Solution {
    public int maxArea(int[] height) {
        // TLE
        // int res = Integer.MIN_VALUE;

        // for (int i = 0; i < height.length; i++) {
        // for (int j = 1; j < height.length; j++) {
        // res = Math.max(res, (j - i) * Math.min(height[i], height[j]));
        // }
        // }

        // return res;

        int res = Integer.MIN_VALUE;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            res = Math.max(res, (right - left) * Math.min(height[left], height[right]));
            if (height[left] > height[right])
                right--;
            else
                left++;
        }

        return res;
    }
}