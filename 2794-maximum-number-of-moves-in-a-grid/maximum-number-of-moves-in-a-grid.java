class Solution {
    public int maxMoves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];

        int maxMoves = 0;

        // Start traversal from each cell in the first column.
        for (int i = 0; i < n; i++) {
            maxMoves = Math.max(maxMoves, dfs(grid, dp, i, 0));
        }

        return maxMoves;
    }

    private int dfs(int[][] grid, int[][] dp, int row, int col) {
        int n = grid.length;
        int m = grid[0].length;

        // If we're out of bounds or if we've already calculated the max moves from this
        // cell, return the stored result.
        if (col >= m - 1)
            return 0;
        if (dp[row][col] != 0)
            return dp[row][col];

        int maxMoves = 0;

        int[][] directions = { { -1, 1 }, { 0, 1 }, { 1, 1 } };

        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            // Check bounds and ensure the move is strictly increasing in value.
            if (newRow >= 0 && newRow < n && newCol < m && grid[newRow][newCol] > grid[row][col]) {
                maxMoves = Math.max(maxMoves, 1 + dfs(grid, dp, newRow, newCol));
            }
        }

        dp[row][col] = maxMoves;
        return maxMoves;
    }
}
