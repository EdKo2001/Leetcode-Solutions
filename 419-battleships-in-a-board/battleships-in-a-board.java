class Solution {
    public int countBattleships(char[][] board) {
        int cnt = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X') {
                    dfs(board, i, j);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 'X') {
            return;
        }

        grid[i][j] = '.';

        dfs(grid, i, j + 1);
        dfs(grid, i + 1, j);
    }
}