class Solution {

    // Possible moves: right, left, up, down
    private final int[][] dir = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

    public int getFood(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Find starting position marked as '*'
        int[] start = { -1, -1 };
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '*') {
                    start[0] = i;
                    start[1] = j;
                    break;
                }
            }
        }

        // BFS queue for level-by-level traversal
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        int steps = 1;

        // BFS traversal
        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            // Process all cells at current level
            while (levelSize-- > 0) {
                int[] pos = queue.poll();

                // Try all four directions
                for (int[] d : dir) {
                    int newRow = d[0] + pos[0];
                    int newCol = d[1] + pos[1];

                    if (isValid(grid, newRow, newCol)) {
                        // Found food
                        if (grid[newRow][newCol] == '#') return steps;

                        // Mark as visited and add to queue
                        grid[newRow][newCol] = 'X';
                        queue.add(new int[] { newRow, newCol });
                    }
                }
            }
            steps++;
        }

        // No path found to food
        return -1;
    }

    // Check if position is within bounds and not blocked
    private boolean isValid(char[][] grid, int row, int col) {
        return (
            row >= 0 &&
            col >= 0 &&
            row < grid.length &&
            col < grid[0].length &&
            grid[row][col] != 'X'
        );
    }
}