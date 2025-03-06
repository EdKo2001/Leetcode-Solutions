/**
 * @param {number[][]} grid
 * @return {number[]}
 */
var findMissingAndRepeatedValues = function (grid) {
    const arr = Array.from({ length: (grid.length * grid[0].length) + 1 }).fill(false);
    const ans = [-1, -1];
    for (let i = 0; i < grid.length; i++) {
        for (let j = 0; j < grid[0].length; j++) {
            if (arr[grid[i][j]]) {
                ans[0] = grid[i][j];
            }
            arr[grid[i][j]] = true;
        }
    }
    for (let i = 1; i < arr.length; i++) {
        if (arr[i] === false) {
            ans[1] = i;
            return ans;
        }
    }
    return ans;
};