class Solution {
    public boolean validTicTacToe(String[] board) {
        int xCount = 0, oCount = 0;

        // Count 'X' and 'O' and check the board for invalid move counts
        for (String row : board) {
            for (char c : row.toCharArray()) {
                if (c == 'X')
                    xCount++;
                else if (c == 'O')
                    oCount++;
            }
        }

        // Validate move counts
        if (oCount > xCount || xCount - oCount > 1)
            return false;

        // Define winning conditions
        boolean xWins = isWinner(board, 'X');
        boolean oWins = isWinner(board, 'O');

        // Validate winning scenarios
        if (xWins && oWins)
            return false; // Both can't win simultaneously
        if (xWins && xCount == oCount)
            return false; // 'X' wins but moves equal
        if (oWins && xCount > oCount)
            return false; // 'O' wins but 'X' played more

        return true;
    }

    // Helper method to check for a winner
    private boolean isWinner(String[] board, char player) {
        for (int i = 0; i < 3; i++) {
            // Check rows and columns
            if ((board[i].charAt(0) == player && board[i].charAt(1) == player && board[i].charAt(2) == player) ||
                    (board[0].charAt(i) == player && board[1].charAt(i) == player && board[2].charAt(i) == player)) {
                return true;
            }
        }
        // Check diagonals
        if ((board[0].charAt(0) == player && board[1].charAt(1) == player && board[2].charAt(2) == player) ||
                (board[0].charAt(2) == player && board[1].charAt(1) == player && board[2].charAt(0) == player)) {
            return true;
        }
        return false;
    }
}
