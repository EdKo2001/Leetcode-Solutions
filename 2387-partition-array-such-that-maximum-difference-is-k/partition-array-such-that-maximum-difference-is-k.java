class Solution {
    public int partitionArray(int[] nums, int k) {
        int cnt = 1;
        Arrays.sort(nums);

        int min = nums[0];
        for (int num : nums) {
            if (num - min > k) {
                cnt++;
                min = num;
            }
        }

        return cnt;
    }
}
