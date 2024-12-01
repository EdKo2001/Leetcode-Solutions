class Solution {
    private int[][] memo;
    private final int MOD = 1_000_000_007; // Modulo constant
    private int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } }; // Up, down, right, left

    public int countPaths(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        memo = new int[m][n];

        long cnt = 0; // Use long to avoid overflow during summation

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cnt = (cnt + dfs(grid, i, j)) % MOD; // Apply modulo during accumulation
            }
        }

        return (int) cnt;
    }

    private int dfs(int[][] grid, int row, int col) {
        if (memo[row][col] != 0)
            return memo[row][col];

        int cnt = 1;

        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length
                    && grid[newRow][newCol] > grid[row][col]) {
                cnt = (cnt + dfs(grid, newRow, newCol)) % MOD; // Apply modulo in each recursive step
            }
        }

        memo[row][col] = cnt;
        return cnt;
    }
}
