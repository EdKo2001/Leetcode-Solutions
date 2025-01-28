/**
 * @param {number[][]} grid
 * @return {number}
 */
var findMaxFish = function (grid) {
    let maxFish = 0;

    const seen = Array.from({ length: grid.length }, () => Array(grid[0].length).fill(false));

    const dfs = (row, col) => {
        // Base case: Check boundaries, zero-value cells, or already seen cells
        if (
            row < 0 ||
            row >= grid.length ||
            col < 0 ||
            col >= grid[0].length ||
            grid[row][col] === 0 ||
            seen[row][col]
        ) {
            return 0;
        }

        seen[row][col] = true;

        let fishCount = grid[row][col];

        fishCount += dfs(row + 1, col);
        fishCount += dfs(row - 1, col);
        fishCount += dfs(row, col + 1);
        fishCount += dfs(row, col - 1);

        return fishCount;
    };

    for (let i = 0; i < grid.length; i++) {
        for (let j = 0; j < grid[0].length; j++) {
            if (grid[i][j] !== 0 && !seen[i][j]) {
                maxFish = Math.max(maxFish, dfs(i, j));
            }
        }
    }

    return maxFish;
};
