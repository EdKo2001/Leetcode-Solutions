/**
 * @param {number} n
 * @return {string[][]}
 */
var solveNQueens = function (n) {
    const ans = [];
    const matrix = Array.from({ length: n }, () => Array(n).fill('.'));
    backtrack(matrix, ans, n, 0);
    return ans;
};

const backtrack = (matrix, ans, n, row) => {
    if (row === n) {
        ans.push(matrix.map(row => row.join('')));
        return;
    }

    // Try every column in the current row
    for (let col = 0; col < n; col++) {
        if (isValid(matrix, row, col, n)) {
            matrix[row][col] = 'Q';
            backtrack(matrix, ans, n, row + 1);
            matrix[row][col] = '.';
        }
    }
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
