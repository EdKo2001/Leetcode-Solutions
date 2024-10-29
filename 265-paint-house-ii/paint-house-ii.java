class Solution {
    public int minCostII(int[][] costs) {
        int n = costs.length;
        int k = costs[0].length;
        
        // DP table
        int[][] dp = new int[n][k];

        // Base case: first house costs
        for (int j = 0; j < k; j++) {
            dp[0][j] = costs[0][j];
        }

        // Fill the DP table
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < k; j++) {
                dp[i][j] = costs[i][j] + findMinCost(dp, i - 1, j, k);
            }
        }

        // Find the minimum cost in the last row
        int minCost = Integer.MAX_VALUE;
        for (int j = 0; j < k; j++) {
            minCost = Math.min(minCost, dp[n - 1][j]);
        }

        return minCost;
    }

    // Helper function to find the minimum cost for the previous house excluding the same color
    private int findMinCost(int[][] dp, int i, int j, int k) {
        int minCost = Integer.MAX_VALUE;
        for (int color = 0; color < k; color++) {
            if (color != j) {
                minCost = Math.min(minCost, dp[i][color]);
            }
        }
        return minCost;
    }
}
