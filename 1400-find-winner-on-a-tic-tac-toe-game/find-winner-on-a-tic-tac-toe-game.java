class Solution {
    public String tictactoe(int[][] moves) {
        char[][] grid = new char[3][3];

        char turn = 'A';
        for (int i = 0; i < moves.length; i++) {
            int row = moves[i][0];
            int col = moves[i][1];
            grid[row][col] = turn;

            // Check for a winner after each move
            if (checkWinner(grid, turn)) {
                return turn == 'A' ? "A" : "B"; // Return the winner
            }

            // Alternate turns
            turn = (turn == 'A') ? 'B' : 'A';
        }

        // If no winner and there are remaining empty spaces, the game is pending
        if (moves.length < 9) {
            return "Pending";
        }

        // If all moves are made and no winner is found, it's a draw
        return "Draw";
    }

    // Function to check if the given player has won
    private boolean checkWinner(char[][] grid, char player) {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if ((grid[i][0] == player && grid[i][1] == player && grid[i][2] == player) || // Row
                    (grid[0][i] == player && grid[1][i] == player && grid[2][i] == player)) { // Column
                return true;
            }
        }

        // Check diagonals
        if ((grid[0][0] == player && grid[1][1] == player && grid[2][2] == player) || // Main diagonal
                (grid[0][2] == player && grid[1][1] == player && grid[2][0] == player)) { // Anti-diagonal
            return true;
        }

        return false;
    }
}
