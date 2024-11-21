class Solution {
    public int numRookCaptures(char[][] board) {
        int cnt = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    cnt = checkAttack(board, i, j);
                }
            }
        }

        return cnt;
    }

    private int checkAttack(char[][] board, int row, int col) {
        int cnt = 0;

        boolean canAttack = false;
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 'p')
                canAttack = true;
            else if (board[row][i] == 'B')
                canAttack = false;
        }

        if (canAttack)
            cnt++;

        canAttack = false;
        for (int i = 7; i > col; i--) {
            if (board[row][i] == 'p')
                canAttack = true;
            else if (board[row][i] == 'B')
                canAttack = false;
        }

        if (canAttack)
            cnt++;

        canAttack = false;
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'p')
                canAttack = true;
            else if (board[i][col] == 'B')
                canAttack = false;
        }

        if (canAttack)
            cnt++;

        canAttack = false;
        for (int i = 7; i > row; i--) {
            if (board[i][col] == 'p')
                canAttack = true;
            else if (board[i][col] == 'B')
                canAttack = false;
        }

        if (canAttack)
            cnt++;

        return cnt;
    }
}