class Solution {
    private int[][] memo; // Memoization table
    private int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } }; // Up, down, right, left

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;

        int m = matrix.length, n = matrix[0].length;
        memo = new int[m][n];

        int longestPath = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                longestPath = Math.max(longestPath, dfs(matrix, i, j));
            }
        }
        return longestPath;
    }

    private int dfs(int[][] matrix, int row, int col) {
        if (memo[row][col] != 0)
            return memo[row][col];

        int maxPath = 1;

        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (newRow >= 0 && newRow < matrix.length && newCol >= 0 && newCol < matrix[0].length
                    && matrix[newRow][newCol] > matrix[row][col]) {
                maxPath = Math.max(maxPath, 1 + dfs(matrix, newRow, newCol));
            }
        }

        memo[row][col] = maxPath;
        return maxPath;
    }
}
