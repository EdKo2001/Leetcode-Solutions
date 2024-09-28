class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int oddPosition = 0;

        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if ((cur & 1) == 0) {
                int temp = nums[oddPosition];
                nums[oddPosition] = cur;
                nums[i] = temp;
                oddPosition++;
            }
        }

        return nums;
    }
}