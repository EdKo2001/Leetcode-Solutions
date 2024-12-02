class TicTacToe {
    char[][] board;

    public TicTacToe(int n) {
        board = new char[n][n];
    }

    public int move(int row, int col, int player) {
        char move = player == 1 ? 'X' : 'O';
        board[row][col] = move;

        if (checkWinner(move))
            return player;

        return 0;
    }

    private boolean checkWinner(char player) {
        int n = board.length;

        boolean mainDiagonal = true;
        boolean antiDiagonal = true;
        for (int i = 0; i < n; i++) {
            if (board[i][i] != player) {
                mainDiagonal = false;
            }
            if (board[i][n - 1 - i] != player) {
                antiDiagonal = false;
            }
        }

        if (mainDiagonal || antiDiagonal)
            return true;

        for (int i = 0; i < n; i++) {
            int consecutiveRow = 0;
            int consecutiveCol = 0;
            for (int j = 0; j < n; j++) {
                if (board[i][j] == player)
                    consecutiveRow++;
                if (board[j][i] == player)
                    consecutiveCol++;
            }
            if (consecutiveRow == n)
                return true;
            if (consecutiveCol == n)
                return true;

        }

        return false;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */