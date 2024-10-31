class Solution {
    public void solveSudoku(char[][] board) {
        backtracking(board);
    }

    private boolean backtracking(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char num = '1'; num <= '9'; num++) {
                        if (isValid(board, i, j, num)) {
                            board[i][j] = num;
                            if (backtracking(board)) {
                                return true;
                            }
                            board[i][j] = '.'; // Undo move if it leads to a dead end
                        }
                    }
                    return false; // No valid number was found, backtrack
                }
            }
        }
        return true; // Board is complete
    }

    private boolean isValid(char[][] board, int row, int col, char num) {
        for (int i = 0; i < 9; i++) {
            // Check the row, column, and 3x3 square
            if (board[row][i] == num || board[i][col] == num ||
                    board[(row / 3) * 3 + i / 3][(col / 3) * 3 + i % 3] == num) {
                return false;
            }
        }
        return true;
    }
}
