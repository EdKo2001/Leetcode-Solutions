/**
 * @param {number[][]} grid
 * @return {number[]}
 */
var findMissingAndRepeatedValues = function (grid) {
    const n = grid.length * grid[0].length;
    const seen = new Set();
    let repeated = -1, sum = 0, expectedSum = (n * (n + 1)) / 2;

    for (const row of grid) {
        for (const num of row) {
            if (seen.has(num)) repeated = num;
            seen.add(num);
            sum += num;
        }
    }

    return [repeated, expectedSum - (sum - repeated)];
};
