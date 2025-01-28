/**
 * @param {number[][]} grid
 * @return {number}
 */
var findMaxFish = function (grid) {
    let max = 0;

    const seen = Array.from({ length: grid.length }, () => new Array(grid[0].length).fill(false));

    for (let i = 0; i < grid.length; i++) {
        for (let y = 0; y < grid[0].length; y++) {
            if (grid[i][y] !== 0) {
                max = Math.max(max, dfs(grid, i, y, seen));
            }
        }
    }
    return max;
};

const dfs = (grid, row, col, seen) => {
    if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] === 0 || seen[row][col]) return 0;

    let max = grid[row][col];

    seen[row][col] = true;

    max = Math.max(max, max + dfs(grid, row + 1, col, seen));
    max = Math.max(max, max + dfs(grid, row - 1, col, seen));;
    max = Math.max(max, max + dfs(grid, row, col + 1, seen));
    max = Math.max(max, max + dfs(grid, row, col - 1, seen));

    return max;
}