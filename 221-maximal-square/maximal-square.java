public class Solution {
    // public int maximalSquare(char[][] matrix) {
    // if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
    // return 0;
    // }

    // int rows = matrix.length;
    // int cols = matrix[0].length;
    // int[][] dp = new int[rows][cols];
    // int maxSide = 0;

    // // Fill the DP array
    // for (int i = 0; i < rows; i++) {
    // for (int j = 0; j < cols; j++) {
    // // If we encounter a '1', calculate the size of the square ending at this
    // cell
    // if (matrix[i][j] == '1') {
    // if (i == 0 || j == 0) {
    // // Cells in the first row or column can only form a square of side 1 if
    // they're '1'
    // dp[i][j] = 1;
    // } else {
    // // Calculate the side of the square by looking at neighboring cells
    // dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) +
    // 1;
    // }
    // // Update maxSide if we've found a larger square
    // maxSide = Math.max(maxSide, dp[i][j]);
    // }
    // }
    // }

    // // Return the area of the largest square found
    // return maxSide * maxSide;
    // }

    // one-dimensional array
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] dp = new int[cols]; // Only store the previous row's results
        int maxSide = 0;
        int prev = 0; // This will store dp[i-1][j-1] for the current cell

        // Iterate through the matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int temp = dp[j]; // Temporarily store current dp[j] before updating it

                if (matrix[i][j] == '1') {
                    if (j == 0) {
                        dp[j] = 1; // Cells in the first column can only form a square of side 1 if they're '1'
                    } else {
                        // Update dp[j] based on minimum of previous values
                        dp[j] = Math.min(Math.min(dp[j], dp[j - 1]), prev) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[j]);
                } else {
                    dp[j] = 0; // Reset dp[j] if the cell in matrix is '0'
                }

                prev = temp; // Update prev for the next iteration
            }
        }

        // Return the area of the largest square found
        return maxSide * maxSide;
    }
}
