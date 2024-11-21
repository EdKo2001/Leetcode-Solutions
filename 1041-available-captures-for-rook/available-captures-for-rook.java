class Solution {
    public int numRookCaptures(char[][] board) {
        int cnt = 0;

        // Locate the rook
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    cnt = checkAttack(board, i, j); // Start checking from the rook's position
                    return cnt; // Only one rook is present, so we can return immediately
                }
            }
        }

        return cnt;
    }

    private int checkAttack(char[][] board, int row, int col) {
        int cnt = 0;

        // Check left
        for (int i = col - 1; i >= 0; i--) {
            if (board[row][i] == 'B')
                break; // Stop if bishop is encountered
            if (board[row][i] == 'p') {
                cnt++;
                break; // Stop after capturing a pawn
            }
        }

        // Check right
        for (int i = col + 1; i < 8; i++) {
            if (board[row][i] == 'B')
                break;
            if (board[row][i] == 'p') {
                cnt++;
                break;
            }
        }

        // Check up
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'B')
                break;
            if (board[i][col] == 'p') {
                cnt++;
                break;
            }
        }

        // Check down
        for (int i = row + 1; i < 8; i++) {
            if (board[i][col] == 'B')
                break;
            if (board[i][col] == 'p') {
                cnt++;
                break;
            }
        }

        return cnt;
    }
}
