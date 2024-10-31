class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> seen = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char current = board[i][j];

                if (current != '.') {
                    // Create unique strings for row, column, and subgrid checks
                    String rowKey = "row" + i + current;
                    String colKey = "col" + j + current;
                    String squareKey = "square" + (i / 3) + (j / 3) + current;

                    // Check if any of these identifiers already exist in `seen` set
                    if (!seen.add(rowKey) || !seen.add(colKey) || !seen.add(squareKey)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
