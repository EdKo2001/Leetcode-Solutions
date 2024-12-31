class Solution {
    public int splitArray(int[] nums, int k) {
        int lo = Arrays.stream(nums).max().getAsInt();
        int hi = Arrays.stream(nums).sum();
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (feasible(nums, k, mid)) hi = mid;
            else lo = ++mid;
        }
        return lo;
    }

    private static boolean feasible(int[] nums, int k, int max) {
        int curSum = 0;
        int arrCnt = 1;  
        for (int num : nums) {
            if (curSum + num > max) {
                curSum = num;
                arrCnt++;
            } else {
                curSum += num;
            }
        }
        return arrCnt <= k;
    }
}
