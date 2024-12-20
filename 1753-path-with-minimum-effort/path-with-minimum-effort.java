// DFS - TLE
// class Solution {
//     int[][] visited;

//     public int minimumEffortPath(int[][] heights) {
//         int n = heights.length;
//         int m = heights[0].length;
//         visited = new int[n][m];

//         for (int[] row : visited) {
//             Arrays.fill(row, Integer.MAX_VALUE);
//         }

//         return dfs(heights, 0, 0, heights[0][0], 0);
//     }

//     public int dfs(int[][] heights, int i, int j, int prev, int maxEffort) {
//         int n = heights.length;
//         int m = heights[0].length;

//         if (i < 0 || i >= n || j < 0 || j >= m) {
//             return Integer.MAX_VALUE;
//         }

//         int effort = Math.abs(heights[i][j] - prev);
//         int currentEffort = Math.max(maxEffort, effort);

//         if (currentEffort >= visited[i][j]) {
//             return Integer.MAX_VALUE;
//         }

//         visited[i][j] = currentEffort;

//         if (i == n - 1 && j == m - 1) {
//             return currentEffort;
//         }

//         int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
//         int minEffort = Integer.MAX_VALUE;

//         for (int[] dir : directions) {
//             int newRow = i + dir[0];
//             int newCol = j + dir[1];
//             minEffort = Math.min(minEffort, dfs(heights, newRow, newCol, heights[i][j], currentEffort));
//         }

//         return minEffort;
//     }
// }

// BFS
// class Solution {
//     public int minimumEffortPath(int[][] heights) {
//         int rows = heights.length, cols = heights[0].length;

//         // Binary search bounds for effort
//         int left = 0, right = 1_000_000, result = 0;

//         while (left <= right) {
//             int mid = left + (right - left) / 2;

//             // Check if we can traverse with this "mid" effort
//             if (canReach(heights, rows, cols, mid)) {
//                 result = mid; // Possible, but try for smaller effort
//                 right = mid - 1;
//             } else {
//                 left = mid + 1; // Impossible, increase the effort
//             }
//         }

//         return result;
//     }

//     // BFS to check if we can reach the bottom-right cell with given effort
//     private boolean canReach(int[][] heights, int rows, int cols, int effort) {
//         Queue<int[]> queue = new LinkedList<>();
//         boolean[][] visited = new boolean[rows][cols];

//         // Start BFS from the top-left cell
//         queue.offer(new int[]{0, 0});
//         visited[0][0] = true;

//         int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

//         while (!queue.isEmpty()) {
//             int[] current = queue.poll();
//             int x = current[0], y = current[1];

//             // If we reach the bottom-right cell, return true
//             if (x == rows - 1 && y == cols - 1) {
//                 return true;
//             }

//             for (int[] dir : directions) {
//                 int newX = x + dir[0];
//                 int newY = y + dir[1];

//                 // Check bounds and effort
//                 if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && !visited[newX][newY]) {
//                     int diff = Math.abs(heights[newX][newY] - heights[x][y]);

//                     // If the difference is within the allowed effort
//                     if (diff <= effort) {
//                         visited[newX][newY] = true;
//                         queue.offer(new int[]{newX, newY});
//                     }
//                 }
//             }
//         }

//         return false;
//     }
// }

// PriorityQueue minHeap
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        // Priority queue: (effort, x, y)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        // Effort to reach each cell, initialized to maximum
        int[][] effortTo = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                effortTo[i][j] = Integer.MAX_VALUE;
            }
        }

        // Start from the top-left corner
        pq.offer(new int[]{0, 0, 0}); // effort, row, col
        effortTo[0][0] = 0;

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int effort = current[0];
            int x = current[1];
            int y = current[2];

            // If we reach the bottom-right cell, return the effort
            if (x == rows - 1 && y == cols - 1) {
                return effort;
            }

            // Explore neighbors
            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                // Check bounds
                if (newX >= 0 && newX < rows && newY >= 0 && newY < cols) {
                    int newEffort = Math.max(effort, Math.abs(heights[newX][newY] - heights[x][y]));

                    // Only update if we found a smaller effort
                    if (newEffort < effortTo[newX][newY]) {
                        effortTo[newX][newY] = newEffort;
                        pq.offer(new int[]{newEffort, newX, newY});
                    }
                }
            }
        }

        return 0; // Should never reach here
    }
}