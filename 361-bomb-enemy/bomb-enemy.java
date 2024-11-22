class Solution {
    public int maxKilledEnemies(char[][] grid) {
        if (grid.length == 0)
            return 0;

        int rows = grid.length;
        int cols = grid[0].length;

        int maxCount = 0;

        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {
                if (grid[row][col] == '0') {
                    int hits = this.killEnemies(row, col, grid);
                    maxCount = Math.max(maxCount, hits);
                }
            }
        }

        return maxCount;
    }

    /**
     * return the number of enemies we kill, starting from the given empty cell.
     */
    private int killEnemies(int row, int col, char[][] grid) {
        int enemyCount = 0;
        // look to the left side of the cell
        for (int c = col - 1; c >= 0; --c) {
            if (grid[row][c] == 'W')
                break;
            else if (grid[row][c] == 'E')
                enemyCount += 1;
        }

        // look to the right side of the cell
        for (int c = col + 1; c < grid[0].length; ++c) {
            if (grid[row][c] == 'W')
                break;
            else if (grid[row][c] == 'E')
                enemyCount += 1;
        }

        // look to the up side of the cell
        for (int r = row - 1; r >= 0; --r) {
            if (grid[r][col] == 'W')
                break;
            else if (grid[r][col] == 'E')
                enemyCount += 1;
        }

        // look to the down side of the cell
        for (int r = row + 1; r < grid.length; ++r) {
            if (grid[r][col] == 'W')
                break;
            else if (grid[r][col] == 'E')
                enemyCount += 1;
        }

        return enemyCount;
    }
}