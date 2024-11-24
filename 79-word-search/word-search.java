class Solution {
    // public boolean exist(char[][] board, String word) {
    //     for (int i = 0; i < board.length; i++) {
    //         for (int j = 0; j < board[0].length; j++) {
    //             if (board[i][j] == word.charAt(0) && dfs(board, i, j, word, 0)) {
    //                 return true;
    //             }
    //         }
    //     }
    //     return false;
    // }

    // private boolean dfs(char[][] board, int i, int j, String word, int target) {
    //     // Base case: If all characters in the word are found
    //     if (target == word.length()) {
    //         return true;
    //     }

    //     // Check boundaries and character match
    //     if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(target)) {
    //         return false;
    //     }

    //     // Mark the current cell as visited by temporarily changing its value
    //     char temp = board[i][j];
    //     board[i][j] = '#';

    //     // Explore all 4 possible directions: right, up, left, down
    //     int[][] directions = { { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 0 } };
    //     for (int[] dir : directions) {
    //         if (dfs(board, i + dir[0], j + dir[1], word, target + 1)) {
    //             return true;
    //         }
    //     }

    //     // Restore the cell's original value
    //     board[i][j] = temp;
    //     return false;
    // }

    // Search Pruning for Optimizing Word Search on Larger Boards
    public boolean exist(char[][] board, String word) {
        // Frequency check before DFS
        if (!canFormWord(board, word)) {
            return false; // Prune immediately if the board lacks characters
        }

        int rows = board.length, cols = board[0].length;

        // Start DFS from each cell
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, i, j, word, 0)) {
                    return true; // Word found
                }
            }
        }

        return false; // Word not found
    }

    // DFS function with backtracking
    private boolean dfs(char[][] board, int row, int col, String word, int index) {
        if (index == word.length()) {
            return true; // Full word matched
        }

        // Boundary check and character match validation
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word.charAt(index)) {
            return false;
        }

        // Mark cell as visited temporarily
        char temp = board[row][col];
        board[row][col] = '#'; // Use a non-character like '#' to mark as visited

        // Explore all 4 directions (right, down, left, up)
        int[][] directions = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };
        for (int[] dir : directions) {
            if (dfs(board, row + dir[0], col + dir[1], word, index + 1)) {
                return true;
            }
        }

        // Restore the original character (backtrack)
        board[row][col] = temp;
        return false;
    }

    // Frequency check function to prune impossible cases early
    private boolean canFormWord(char[][] board, String word) {
        Map<Character, Integer> boardFreq = new HashMap<>();
        for (char[] row : board) {
            for (char ch : row) {
                boardFreq.put(ch, boardFreq.getOrDefault(ch, 0) + 1);
            }
        }

        // Check each character frequency in the word
        for (char ch : word.toCharArray()) {
            if (boardFreq.getOrDefault(ch, 0) == 0) {
                return false; // Not enough occurrences of 'ch' to form the word
            }
            boardFreq.put(ch, boardFreq.get(ch) - 1);
        }

        return true;
    }
}
