class Solution {
    public int minCost(int[][] costs) {
        int minCost = Integer.MAX_VALUE;
        Integer memo[][] = new Integer[costs.length][costs[0].length];

        for (int j = 0; j < costs[0].length; j++) {
            minCost = Math.min(minCost, bfs(costs, 0, j, memo));
        }

        return minCost;
    }

    private int bfs(int[][] costs, int i, int j, Integer[][] memo) {
        int n = costs.length;
        int m = costs[0].length;

        if (i + 1 > n)
            return 0;

        if (memo[i][j] != null)
            return memo[i][j];

        int minCost = Integer.MAX_VALUE;

        int red = j != 0 ? costs[i][j] + bfs(costs, i + 1, 0, memo) : Integer.MAX_VALUE;
        int blue = j != 1 && j + 1 <= m ? costs[i][j] + bfs(costs, i + 1, 1, memo) : Integer.MAX_VALUE;
        int green = j != 2 && j + 2 <= m ? costs[i][j] + bfs(costs, i + 1, 2, memo) : Integer.MAX_VALUE;

        minCost = Math.min(red, Math.min(blue, green));
        memo[i][j] = minCost;
        return minCost;
    }
}