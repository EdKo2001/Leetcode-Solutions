class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        // Two-pointer approach: start from both ends of the array
        int left = 0;
        int right = n - 1;
        int resPointer = n - 1;

        while (left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];

            if (leftSquare > rightSquare) {
                res[resPointer] = leftSquare;
                left++;
            } else {
                res[resPointer] = rightSquare;
                right--;
            }
            resPointer--;
        }

        return res;
    }
}