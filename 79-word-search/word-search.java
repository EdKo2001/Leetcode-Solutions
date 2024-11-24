class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int target) {
        // Base case: If all characters in the word are found
        if (target == word.length()) {
            return true;
        }

        // Check boundaries and character match
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(target)) {
            return false;
        }

        // Mark the current cell as visited by temporarily changing its value
        char temp = board[i][j];
        board[i][j] = '#';

        // Explore all 4 possible directions: right, up, left, down
        int[][] directions = { { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 0 } };
        for (int[] dir : directions) {
            if (dfs(board, i + dir[0], j + dir[1], word, target + 1)) {
                return true;
            }
        }

        // Restore the cell's original value
        board[i][j] = temp;
        return false;
    }
}
