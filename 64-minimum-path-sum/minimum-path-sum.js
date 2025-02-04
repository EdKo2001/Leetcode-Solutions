/**
 * @param {number[][]} grid
 * @return {number}
 */
var minPathSum = function (grid) {
    let m = grid.length, n = grid[0].length;
    let memo = Array.from({ length: m }, () => Array(n).fill(-1));
    return dfs(grid, 0, 0, memo);
};

function dfs(grid, i, j, memo) {
    let m = grid.length, n = grid[0].length;

    if (i === m - 1 && j === n - 1) return grid[i][j];

    if (i >= m || j >= n) return Infinity;

    if (memo[i][j] !== -1) return memo[i][j];

    memo[i][j] = grid[i][j] + Math.min(dfs(grid, i + 1, j, memo), dfs(grid, i, j + 1, memo));
    return memo[i][j];
}
