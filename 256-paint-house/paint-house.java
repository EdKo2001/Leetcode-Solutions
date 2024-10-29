class Solution {
    public int minCost(int[][] costs) {
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

        // Base case: if we've reached beyond the last row
        if (i >= n)
            return 0;

        // Use memoized result if available
        if (memo[i][j] != null)
            return memo[i][j];

        // Compute minimum cost to paint current house i with color j
        int nextCostRed = j != 0 ? dfs(costs, i + 1, 0, memo) : Integer.MAX_VALUE;
        int nextCostBlue = j != 1 ? dfs(costs, i + 1, 1, memo) : Integer.MAX_VALUE;
        int nextCostGreen = j != 2 ? dfs(costs, i + 1, 2, memo) : Integer.MAX_VALUE;

        // Current cell cost + minimum of future options
        int minCost = costs[i][j] + Math.min(nextCostRed, Math.min(nextCostBlue, nextCostGreen));

        // Memoize the result
        memo[i][j] = minCost;

        return minCost;
    }
}
