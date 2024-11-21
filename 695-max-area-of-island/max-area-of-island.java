class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, i, j));
                    // maxArea = Math.max(maxArea, bfs(grid, i, j));
                }
            }
        }

        return maxArea;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }

        grid[i][j] = 0;

        int area = 1;

        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        for (int[] dir : directions) {
            int newRow = i + dir[0];
            int newCol = j + dir[1];

            area += dfs(grid, newRow, newCol);
        }

        return area;
    }

    // private int bfs(int[][] grid, int i, int j) {
    //     int area = 0;
    //     int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    //     Queue<int[]> queue = new LinkedList<>();
    //     queue.add(new int[] { i, j });
    //     grid[i][j] = 0;

    //     while (!queue.isEmpty()) {
    //         int[] current = queue.poll();
    //         int x = current[0], y = current[1];
    //         area++;

    //         for (int[] dir : directions) {
    //             int row = x + dir[0];
    //             int col = y + dir[1];

    //             if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == 1) {
    //                 grid[row][col] = 0;
    //                 queue.add(new int[] { row, col });
    //             }
    //         }
    //     }

    //     return area;
    // }
}
