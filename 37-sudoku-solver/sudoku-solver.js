/**
 * @param {character[][]} board
 * @return {void} Do not return anything, modify board in-place instead.
 */
function solveSudoku(board) {
    backtrack(board);
}

function backtrack(board) {
    for (let i = 0; i < 9; i++) {
        for (let j = 0; j < 9; j++) {
            if (board[i][j] === '.') {
                for (let d = 1; d <= 9; d++) {
                    const num = d.toString();
                    if (isValid(board, i, j, num)) {
                        board[i][j] = num;
                        if (backtrack(board)) return true;
                        board[i][j] = '.'; // Undo move if it leads to a dead end
                    }
                }
                return false; // No valid number was found, trigger backtracking
            }
        }
    }
    return true; // Board is complete
}

function isValid(board, row, col, num) {
    for (let i = 0; i < 9; i++) {
        // Check row and column
        if (board[row][i] === num || board[i][col] === num) return false;
        // Check the 3x3 sub-box
        let boxRow = 3 * Math.floor(row / 3) + Math.floor(i / 3);
        let boxCol = 3 * Math.floor(col / 3) + (i % 3);
        if (board[boxRow][boxCol] === num) return false;
    }
    return true;
}
