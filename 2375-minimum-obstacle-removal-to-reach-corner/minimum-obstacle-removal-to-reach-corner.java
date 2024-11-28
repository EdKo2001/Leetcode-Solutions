public class Solution {
    public int minimumObstacles(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        int[][] dist = new int[rows][cols];

        // Initialize distances with a large value
        for (int[] row : dist)
            Arrays.fill(row, Integer.MAX_VALUE);
        dist[0][0] = 0;

        Deque<int[]> deque = new LinkedList<>();
        deque.offerFirst(new int[] { 0, 0 }); // Start from top-left corner

        while (!deque.isEmpty()) {
            int[] current = deque.pollFirst();
            int r = current[0], c = current[1];

            // If we reach bottom-right corner, return the result
            if (r == rows - 1 && c == cols - 1)
                return dist[r][c];

            for (int[] dir : directions) {
                int newRow = r + dir[0], newCol = c + dir[1];
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                    int newDist = dist[r][c] + grid[newRow][newCol];
                    if (newDist < dist[newRow][newCol]) {
                        dist[newRow][newCol] = newDist;
                        if (grid[newRow][newCol] == 0) {
                            deque.offerFirst(new int[] { newRow, newCol }); // No obstacle: prioritize
                        } else {
                            deque.offerLast(new int[] { newRow, newCol }); // Obstacle: lower priority
                        }
                    }
                }
            }
        }
        return -1; // Should not reach here
    }
}
