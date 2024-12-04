class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n];
        
        Arrays.fill(res, -1);

        int windowSize = 2 * k + 1;
        
        if (windowSize > n) return res;

        long sum = 0;
        for (int i = 0; i < windowSize; i++) {
            sum += nums[i];
        }
        
        res[k] = (int) (sum / windowSize);
        
        for (int i = k + 1; i < n - k; i++) {
            sum = sum - nums[i - k - 1] + nums[i + k];
            res[i] = (int) (sum / windowSize);
        }

        return res;
    }
}
