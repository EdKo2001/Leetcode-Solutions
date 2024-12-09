class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;

        // Initialize queue with rotten oranges and count fresh oranges
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[] { i, j, 0 });
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        // Early exit if there are no fresh oranges
        if (freshCount == 0) return 0;

        int time = 0;
        int[] dx = {0, 0, 1, -1}; // Directions for rows (up, down)
        int[] dy = {1, -1, 0, 0}; // Directions for columns (right, left)

        // BFS to rot fresh oranges
        while (!queue.isEmpty()) {
            int[] rotten = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nextRow = rotten[0] + dx[d];
                int nextCol = rotten[1] + dy[d];
                if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < m && grid[nextRow][nextCol] == 1) {
                    grid[nextRow][nextCol] = 2; // Mark as rotten
                    queue.offer(new int[] { nextRow, nextCol, rotten[2] + 1 });
                    freshCount--; // Decrease count of fresh oranges
                    time = Math.max(time, rotten[2] + 1); // Update time
                }
            }
        }

        // If fresh oranges remain, return -1
        return freshCount == 0 ? time : -1;
    }
}
