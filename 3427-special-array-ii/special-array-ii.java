class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] parityViolation = new int[n];

        // Build the parity violation array
        for (int i = 1; i < n; i++) {
            if ((nums[i] % 2) == (nums[i - 1] % 2)) {
                parityViolation[i] = 1; // Same parity
            }
        }

        // Compute prefix sum for parity violations
        int[] prefixSum = new int[n];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + parityViolation[i];
        }

        // Answer queries
        int q = queries.length;
        boolean[] answer = new boolean[q];
        for (int i = 0; i < q; i++) {
            int from = queries[i][0];
            int to = queries[i][1];

            // Check the sum of parity violations in the range
            int violations = prefixSum[to] - prefixSum[from];
            answer[i] = (violations == 0);
        }

        return answer;
    }
}
