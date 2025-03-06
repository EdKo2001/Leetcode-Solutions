/**
 * @param {number[][]} grid
 * @return {number[]}
 */
var findMissingAndRepeatedValues = function(grid) {
    const n = grid.length * grid[0].length;
    const seen = Array(n).fill(false);
    let repeated = -1, missing = -1;

    for (let i = 0; i < grid.length; i++) {
        for (let j = 0; j < grid[0].length; j++) {
            const num = grid[i][j];
            if (seen[num - 1]) {
                repeated = num;
            }
            seen[num - 1] = true;
        }
    }

    missing = seen.indexOf(false) + 1; // Find the missing number

    return [repeated, missing];
};


// /**
//  * @param {number[][]} grid
//  * @return {number[]}
//  */
// var findMissingAndRepeatedValues = function (grid) {
//     const n = grid.length * grid[0].length;
//     const seen = new Set();
//     let repeated = -1, sum = 0, expectedSum = (n * (n + 1)) / 2;

//     for (const row of grid) {
//         for (const num of row) {
//             if (seen.has(num)) repeated = num;
//             seen.add(num);
//             sum += num;
//         }
//     }

//     return [repeated, expectedSum - (sum - repeated)];
// };
