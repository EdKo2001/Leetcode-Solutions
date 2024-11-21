class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];

        // Mark walls as -1 and guards as -2
        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = -1;
        }
        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = -2;
        }

        // Directions for propagation: up, down, left, right
        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        // Mark cells guarded by each guard
        for (int[] guard : guards) {
            int x = guard[0];
            int y = guard[1];

            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                while (newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] != -1
                        && grid[newX][newY] != -2) {
                    if (grid[newX][newY] == 0) {
                        grid[newX][newY] = 1; // Mark as guarded
                    }
                    newX += dir[0];
                    newY += dir[1];
                }
            }
        }

        // Count unguarded cells
        int unguardedCells = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    unguardedCells++;
                }
            }
        }

        return unguardedCells;
    }
}
