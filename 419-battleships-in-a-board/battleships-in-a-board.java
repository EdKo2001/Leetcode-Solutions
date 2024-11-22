class Solution {
    public int countBattleships(char[][] board) {
        int cnt = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X') {
                    // dfs(board, i, j);
                    // bfs(board, i, j);
                    // cnt++;

                    if ((i == 0 || board[i - 1][j] == '.') && (j == 0 || board[i][j - 1] == '.')) {
                        cnt++;
                    }
                }
            }
        }

        return cnt;
    }

    // private void dfs(char[][] grid, int i, int j) {
    // if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j]
    // != 'X') {
    // return;
    // }

    // grid[i][j] = '.';

    // dfs(grid, i, j + 1);
    // dfs(grid, i + 1, j);
    // }

    // private void bfs(char[][] grid, int i, int j) {
    // Queue<int[]> queue = new LinkedList<>();
    // queue.offer(new int[] { i, j });

    // while (!queue.isEmpty()) {
    // int[] location = queue.poll();
    // int row = location[0];
    // int col = location[1];

    // grid[row][col] = '.';

    // int[][] directions = { { 0, 1 }, { 1, 0 } };
    // for (int[] direction : directions) {
    // int newRow = row + direction[0];
    // int newCol = col + direction[1];

    // if (newRow < 0 || newRow >= grid.length || newCol < 0 || newCol >=
    // grid[0].length
    // || grid[newRow][newCol] != 'X')
    // continue;

    // queue.offer(new int[] { newRow, newCol });
    // }
    // }
    // }
}