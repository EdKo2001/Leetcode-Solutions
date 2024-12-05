class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int cnt = 0;
        int curr = 1;

        int start = 0;
        for (int end = 0; end < nums.length; end++) {
            curr *= nums[end];

            while (curr >= k && start <= end) {
                curr /= nums[start];
                start++;
            }

            cnt += end - start + 1;
        }

        return cnt;
    }
}