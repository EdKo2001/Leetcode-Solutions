class TicTacToe {
    // private int[][] board;
    // private int n;

    // public TicTacToe(int n) {
    //     board = new int[n][n];
    //     this.n = n;
    // }

    // public int move(int row, int col, int player) {
    //     board[row][col] = player;

    //     if (checkWinner(player))
    //         return player;

    //     return 0;
    // }

    // private boolean checkWinner(int player) {
    //     boolean mainDiagonal = true;
    //     boolean antiDiagonal = true;
    //     for (int i = 0; i < n; i++) {
    //         if (board[i][i] != player) {
    //             mainDiagonal = false;
    //         }
    //         if (board[i][n - 1 - i] != player) {
    //             antiDiagonal = false;
    //         }
    //     }

    //     if (mainDiagonal || antiDiagonal)
    //         return true;

    //     for (int i = 0; i < n; i++) {
    //         int consecutiveRow = 0;
    //         int consecutiveCol = 0;
    //         for (int j = 0; j < n; j++) {
    //             if (board[i][j] == player)
    //                 consecutiveRow++;
    //             if (board[j][i] == player)
    //                 consecutiveCol++;
    //         }
    //         if (consecutiveRow == n)
    //             return true;
    //         if (consecutiveCol == n)
    //             return true;

    //     }

    //     return false;
    // }

    int[] rows;
    int[] cols;
    int diagonal;
    int antiDiagonal;

    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
    }

    public int move(int row, int col, int player) {
        int currentPlayer = (player == 1) ? 1 : -1;
        // update currentPlayer in rows and cols arrays
        rows[row] += currentPlayer;
        cols[col] += currentPlayer;
        // update diagonal
        if (row == col) {
            diagonal += currentPlayer;
        }
        //update anti diagonal
        if (col == (cols.length - row - 1)) {
            antiDiagonal += currentPlayer;
        }
        int n = rows.length;
        // check if the current player wins
        if (Math.abs(rows[row]) == n ||
                Math.abs(cols[col]) == n ||
                Math.abs(diagonal) == n ||
                Math.abs(antiDiagonal) == n) {
            return player;
        }
        // No one wins
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */