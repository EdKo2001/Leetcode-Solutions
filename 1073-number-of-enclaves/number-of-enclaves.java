class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        // Step 1: DFS from the boundary cells (first and last row, first and last column)
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1 && !visited[i][0]) {
                dfs(i, 0, grid, visited);  // First column
            }
            if (grid[i][n - 1] == 1 && !visited[i][n - 1]) {
                dfs(i, n - 1, grid, visited);  // Last column
            }
        }
        for (int j = 0; j < n; j++) {
            if (grid[0][j] == 1 && !visited[0][j]) {
                dfs(0, j, grid, visited);  // First row
            }
            if (grid[m - 1][j] == 1 && !visited[m - 1][j]) {
                dfs(m - 1, j, grid, visited);  // Last row
            }
        }

        // Step 2: Count the remaining unvisited land cells
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    cnt++;  // These land cells cannot walk off the boundary
                }
            }
        }

        return cnt;
    }

    private void dfs(int row, int col, int[][] grid, boolean[][] visited) {
        // Out of bounds check: if we go out of bounds, we are touching the boundary
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return;
        }

        // If it's already visited or a water cell (0), return
        if (visited[row][col] || grid[row][col] == 0) {
            return;
        }

        visited[row][col] = true;

        // Directions for the 4 possible neighbors (right, down, left, up)
        int[][] directions = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            dfs(newRow, newCol, grid, visited);  // Continue DFS for neighbors
        }
    }
}
