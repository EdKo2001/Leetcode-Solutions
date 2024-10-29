class Solution {
    public int minCost(int[][] costs) {
        int n = costs.length;
        if (n == 0)
            return 0; // Handle edge case of no houses
        int m = costs[0].length;
        if (m == 0)
            return 0; // Handle edge case of no colors

        // DP table
        int[][] dp = new int[n][m];

        // Base case: first house costs
        for (int j = 0; j < costs[0].length; j++) {
            dp[0][j] = costs[0][j];
        }

        // Fill the DP table
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = costs[i][j] + findMinCost(dp, i - 1, j, m);
            }
        }
        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            minCost = Math.min(minCost, dp[n - 1][i]);
        }

        return minCost;

    }

    private int findMinCost(int[][] dp, int i, int j, int k) {
        int minCost = Integer.MAX_VALUE;

        for (int color = 0; color < k; color++) {
            if (j != color) {
                minCost = Math.min(minCost, dp[i][color]);
            }
        }

        return minCost;
    }
}
