class Solution {
    public int countSquares(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int cnt = 0;
        
        // Initialize 1D dp array to store the side length of largest square ending at each cell in a row
        int[] dp = new int[cols];
        int prev = 0; // Store the value of dp[j-1] from the previous row

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int temp = dp[j]; // Store current dp[j] before updating it
                if (matrix[i][j] == 1) {
                    if (j == 0) {
                        dp[j] = 1; // If at the first column, only 1 square of size 1 is possible
                    } else {
                        dp[j] = Math.min(Math.min(dp[j - 1], prev), dp[j]) + 1;
                    }
                    cnt += dp[j]; // Add the current square count to total
                } else {
                    dp[j] = 0; // Reset dp[j] if matrix[i][j] is 0
                }
                prev = temp; // Update prev for the next column
            }
        }

        return cnt;
    }
}
