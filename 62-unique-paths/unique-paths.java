class Solution {
    public int uniquePaths(int m, int n) {
        //Time Complexity: O(m * n), since we iterate over the entire grid.   
        // Space Complexity: O(m * n), due to the 2D DP array.
        // // Create a 2D DP array to store the number of unique paths to each cell
        // int[][] dp = new int[m][n];
        
        // // Set the first row and first column to 1, because there's only one way
        // // to reach any cell in the first row (all right moves) or first column (all down moves)
        // for (int i = 0; i < m; i++) {
        //     dp[i][0] = 1;
        // }
        // for (int j = 0; j < n; j++) {
        //     dp[0][j] = 1;
        // }
        
        // // Fill in the DP table
        // for (int i = 1; i < m; i++) {
        //     for (int j = 1; j < n; j++) {
        //         // The number of ways to reach a cell is the sum of the ways
        //         // to reach the cell from the left and from above
        //         dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        //     }
        // }
        
        // // Return the value at the bottom-right corner, which is the answer
        // return dp[m - 1][n - 1];

        // Time Complexity: O(m * n), since we iterate over the entire grid. 
        // Space Complexity: O(n), as we only use a 1D array of size \U0001d45b n.
        // Create a 1D DP array
        int[] dp = new int[n];

        // Initialize the first row with all 1s, as there's only one way to reach any
        // cell in the first row
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        // Fill the DP array for subsequent rows
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }

        // The last element in the array will contain the number of unique paths
        return dp[n - 1];
    }
}