class Solution {

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        // Number of possible subarray starting positions
        int n = nums.length - k + 1;

        // Calculate sum of all possible k-length subarrays
        int[] sums = new int[n];
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }
        sums[0] = windowSum;

        // Sliding window to calculate remaining sums
        for (int i = k; i < nums.length; i++) {
            windowSum = windowSum - nums[i - k] + nums[i];
            sums[i - k + 1] = windowSum;
        }

        // memo[i][j]: max sum possible starting from index i with j subarrays remaining
        int[][] memo = new int[n][4];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        List<Integer> indices = new ArrayList<>();

        // First find optimal sum using DP
        dp(sums, k, 0, 3, memo);

        // Then reconstruct the path to find indices
        dfs(sums, k, 0, 3, memo, indices);

        int[] result = new int[3];
        for (int i = 0; i < 3; i++) {
            result[i] = indices.get(i);
        }

        return result;
    }

    // DP function to find maximum possible sum
    private int dp(int[] sums, int k, int idx, int rem, int[][] memo) {
        if (rem == 0) return 0;
        if (idx >= sums.length) {
            return rem > 0 ? Integer.MIN_VALUE : 0;
        }

        if (memo[idx][rem] != -1) {
            return memo[idx][rem];
        }

        // Try taking current subarray vs skipping it
        int withCurrent = sums[idx] + dp(sums, k, idx + k, rem - 1, memo);
        int skipCurrent = dp(sums, k, idx + 1, rem, memo);

        memo[idx][rem] = Math.max(withCurrent, skipCurrent);
        return memo[idx][rem];
    }

    // DFS to reconstruct the solution path
    private void dfs(
        int[] sums,
        int k,
        int idx,
        int rem,
        int[][] memo,
        List<Integer> indices
    ) {
        if (rem == 0) return;
        if (idx >= sums.length) return;

        int withCurrent = sums[idx] + dp(sums, k, idx + k, rem - 1, memo);
        int skipCurrent = dp(sums, k, idx + 1, rem, memo);

        // Choose path that gave optimal result in DP
        if (withCurrent >= skipCurrent) { // Take current subarray
            indices.add(idx);
            dfs(sums, k, idx + k, rem - 1, memo, indices);
        } else { // Skip current subarray
            dfs(sums, k, idx + 1, rem, memo, indices);
        }
    }
}