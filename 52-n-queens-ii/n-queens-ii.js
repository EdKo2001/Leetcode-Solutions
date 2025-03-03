/**
 * @param {number} n
 * @return {string[][]}
 */
var totalNQueens = function (n) {
    const matrix = Array.from({ length: n }, () => Array(n).fill('.'));
    return backtrack(matrix, n, 0);
};

const backtrack = (matrix, n, row) => {
    if (row === n) {
        return 1;
    }

    let cnt = 0;

    // Try every column in the current row
    for (let col = 0; col < n; col++) {
        if (isValid(matrix, row, col, n)) {
            matrix[row][col] = 'Q';
            cnt += backtrack(matrix, n, row + 1);
            matrix[row][col] = '.';
        }
    }

    return cnt;
};

const isValid = (matrix, row, col, n) => {
    // Check column
    for (let i = 0; i < row; i++) {
        if (matrix[i][col] === 'Q') return false;
    }

    // Check diagonals
    for (let i = 1; i <= row; i++) {
        // Check top-left diagonal
        if (col - i >= 0 && matrix[row - i][col - i] === 'Q') return false;
        // Check top-right diagonal
        if (col + i < n && matrix[row - i][col + i] === 'Q') return false;
    }

    return true;
};
