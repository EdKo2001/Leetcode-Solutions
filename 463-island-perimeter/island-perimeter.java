class Solution {
    // public int islandPerimeter(int[][] grid) {
    //     for (int i = 0; i < grid.length; i++) {
    //         for (int j = 0; j < grid[0].length; j++) {
    //             if (grid[i][j] == 1) {
    //                 return dfs(grid, i, j);
    //             }
    //         }
    //     }

    //     return 0;
    // }

    // private int dfs(int[][] grid, int i, int j) {
    //     if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0)
    //         return 1;

    //     // If the cell is already visited, return 0 to avoid counting again
    //     if (grid[i][j] == -1) {
    //         return 0;
    //     }

    //     // Mark the cell as visited
    //     grid[i][j] = -1;

    //     int cnt = 0;

    //     cnt += dfs(grid, i + 1, j);
    //     cnt += dfs(grid, i - 1, j);
    //     cnt += dfs(grid, i, j + 1);
    //     cnt += dfs(grid, i, j - 1);

    //     return cnt;
    // }

    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        int result = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    result += 4;
                    
                    if (r > 0 && grid[r-1][c] == 1) {
                        result -= 2;
                    }
                    
                    if (c > 0 && grid[r][c-1] == 1) {
                        result -= 2;
                    }
                }
            }
        }
        
        return result;
    }
}