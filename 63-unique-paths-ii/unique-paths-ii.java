class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int r = obstacleGrid.length;
        int c = obstacleGrid[0].length;
        int[][] dp = new int[r][c];

        for (int i = 0; i < c; i++) {
            if (obstacleGrid[0][i] == 1) {
                break; // If there's an obstacle, all cells after it should be 0
            }
            dp[0][i] = 1;
        }

        for (int i = 0; i < r; i++) {
            if (obstacleGrid[i][0] == 1) {
                break; // If there's an obstacle, all cells after it should be 0
            }
            dp[i][0] = 1;
        }

        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }

            }
        }

        return dp[r - 1][c - 1];
    }
}
