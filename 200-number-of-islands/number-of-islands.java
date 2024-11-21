class Solution {
    public int numIslands(char[][] grid) {
        int cnt = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    cnt++;
                    // dfs(grid, i, j);
                    bfs(grid, i, j);
                }
            }
        }

        return cnt;
    }

    // private void dfs(char[][] grid, int i, int j) {
    //     if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0')
    //         return;

    //     grid[i][j] = '0';

    //     bfs(grid, i + 1, j);
    //     bfs(grid, i - 1, j);
    //     bfs(grid, i, j + 1);
    //     bfs(grid, i, j - 1);
    // }

    private void bfs(char[][] grid, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { i, j });
        grid[i][j] = '0';
        
        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        while (!queue.isEmpty()) {
            int[] pair = queue.poll();
            int row = pair[0];
            int col = pair[1];
    

            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow < 0 || newRow >= grid.length || newCol < 0 || newCol >= grid[0].length
                        || grid[newRow][newCol] == '0')
                    continue;

                queue.offer(new int[] { newRow, newCol });
                grid[newRow][newCol] = '0';

            }
        }
    }
}