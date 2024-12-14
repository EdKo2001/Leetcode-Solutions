class Solution {
    public long countSubarrays(int[] nums, long k) {
        long cnt = 0;
        int start = 0;
        long currWindowSum = 0;
        for (int end = 0; end < nums.length; end++) {
            currWindowSum += nums[end];
            int windowSize = end - start + 1;
            while (currWindowSum * windowSize >= k) {
                currWindowSum -= nums[start++];
                windowSize = end - start + 1;
            }
            cnt += windowSize;
        }
        return cnt;
    }
}