class Solution {
    public int minCostII(int[][] costs) {
        int minCost = Integer.MAX_VALUE;
        Integer[][] memo = new Integer[costs.length][costs[0].length];

        // Try starting with each color for the first house
        for (int j = 0; j < costs[0].length; j++) {
            minCost = Math.min(minCost, dfs(costs, 0, j, memo));
        }

        return minCost;
    }

    private int dfs(int[][] costs, int i, int j, Integer[][] memo) {
        int n = costs.length;
        int m = costs[0].length;

        // Base case: if we've reached beyond the last row
        if (i >= n)
            return 0;

        // Use memoized result if available
        if (memo[i][j] != null)
            return memo[i][j];

        int minCost = Integer.MAX_VALUE;

        for (int color = 0; color < m; color++) {
            if (color != j) {
                minCost = Math.min(minCost, costs[i][j] + dfs(costs, i + 1, color, memo));
            }
        }

        // Memoize the result
        memo[i][j] = minCost;

        return minCost;
    }
}
