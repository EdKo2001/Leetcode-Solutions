class Solution {
    public int islandPerimeter(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return dfs(grid, i, j);
                }
            }
        }

        return 0;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0)
            return 1;

        // If the cell is already visited, return 0 to avoid counting again
        if (grid[i][j] == -1) {
            return 0;
        }

        // Mark the cell as visited
        grid[i][j] = -1;

        int cnt = 0;

        cnt += dfs(grid, i + 1, j);
        cnt += dfs(grid, i - 1, j);
        cnt += dfs(grid, i, j + 1);
        cnt += dfs(grid, i, j - 1);

        return cnt;
    }
}