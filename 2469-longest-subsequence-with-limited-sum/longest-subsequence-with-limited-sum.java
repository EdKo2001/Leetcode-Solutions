class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);

        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int query = queries[i];

            int count = binarySearch(prefixSum, query);
            ans[i] = count;
        }

        return ans;
    }

    private int binarySearch(int[] prefixSum, int query) {
        int low = 0, high = prefixSum.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (prefixSum[mid] <= query) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
