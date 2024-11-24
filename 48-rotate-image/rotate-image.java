class Solution {
    public void rotate(int[][] matrix) {
        // Auxiliary matrix
        // Create auxiliary matrix to store the rotated result
        int[][] res = new int[matrix.length][matrix[0].length];

        int n = matrix.length; // Assuming it's an n x n matrix

        // Use nested loops to populate the auxiliary matrix with rotated elements
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                res[col][n - 1 - row] = matrix[row][col]; // Main rotation logic
            }
        }

        // Copy the rotated matrix (res) back to the original matrix
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                matrix[row][col] = res[row][col]; // Copy values back to matrix
            }
        }

        // In-place
    }
}