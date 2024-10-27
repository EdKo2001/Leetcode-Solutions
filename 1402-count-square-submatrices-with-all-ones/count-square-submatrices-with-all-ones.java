class Solution {
    public int countSquares(int[][] matrix) {
        int cnt = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int left_square = 0, top_square = 0, diagonal_square = 0;

                if (i > 0)
                    top_square = matrix[i - 1][j];
                if (j > 0)
                    left_square = matrix[i][j - 1];
                if (i > 0 && j > 0)
                    diagonal_square = matrix[i - 1][j - 1];

                if (matrix[i][j] == 1) {
                    matrix[i][j] = Math.min(Math.min(top_square, left_square), diagonal_square) + 1;
                    cnt += matrix[i][j];
                }
            }
        }

        return cnt;
    }
}