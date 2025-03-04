/**
 * @param {character[][]} board
 * @return {void} Do not return anything, modify board in-place instead.
 */
var solve = function (board) {
    const m = board.length;
    const n = board[0].length;

    const dfs = (row, col) => {
        if (row < 0 || row >= m || col < 0 || col >= n || board[row][col] !== "O") {
            return;
        }

        board[row][col] = "T";

        const directions = [[1, 0], [-1, 0], [0, 1], [0, -1]];
        for (const [dx, dy] of directions) {
            dfs(row + dx, col + dy);
        }
    };

    // Step 1: Run DFS on all 'O' cells on the border
    for (let i = 0; i < m; i++) {
        if (board[i][0] === "O") dfs(i, 0); // Left border
        if (board[i][n - 1] === "O") dfs(i, n - 1); // Right border
    }

    for (let j = 0; j < n; j++) {
        if (board[0][j] === "O") dfs(0, j); // Top border
        if (board[m - 1][j] === "O") dfs(m - 1, j); // Bottom border
    }

    // Step 2: Flip all remaining 'O' to 'X' (these are truly surrounded)
    // Step 3: Convert 'T' back to 'O' (these were connected to the border)
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (board[i][j] === "O") {
                board[i][j] = "X"; // Flip surrounded regions
            } else if (board[i][j] === "T") {
                board[i][j] = "O"; // Restore border-connected regions
            }
        }
    }

    return board;
};
