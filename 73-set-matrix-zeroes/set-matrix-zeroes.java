class Solution {
    public void setZeroes(int[][] matrix) {
        HashSet<Pair<Integer, Integer>> zeroes = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0)
                    zeroes.add(new Pair(i, j));
            }
        }

        for (Pair<Integer, Integer> zero : zeroes) {
            setZeroes(matrix, zero.getKey(), zero.getValue());
        }
    }

    private void setZeroes(int[][] matrix, int i, int j) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row][j] = 0;
        }
        for (int col = 0; col < matrix[0].length; col++) {
            matrix[i][col] = 0;
        }
    }
}