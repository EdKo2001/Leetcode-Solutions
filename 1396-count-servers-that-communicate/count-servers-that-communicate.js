// /**
//  * @param {number[][]} grid
//  * @return {number}
//  */
// var countServers = function (grid) {
//     let rows = grid.length;
//     let cols = grid[0].length;

//     // Count servers in each row and column
//     let rowCount = new Array(rows).fill(0);
//     let colCount = new Array(cols).fill(0);

//     // First pass to calculate the counts
//     for (let row = 0; row < rows; row++) {
//         for (let col = 0; col < cols; col++) {
//             if (grid[row][col] === 1) {
//                 rowCount[row]++;
//                 colCount[col]++;
//             }
//         }
//     }

//     // Second pass to count servers that can communicate
//     let cnt = 0;
//     for (let row = 0; row < rows; row++) {
//         for (let col = 0; col < cols; col++) {
//             if (grid[row][col] === 1 && (rowCount[row] > 1 || colCount[col] > 1)) {
//                 cnt++;
//             }
//         }
//     }

//     return cnt;
// };

/**
 * @param {number[][]} grid
 * @return {number}
 */
var countServers = function (grid) {
    let cnt = 0;

    // Create a "seen" array to track visited cells
    const seen = Array.from({ length: grid.length }, () =>
        new Array(grid[0].length).fill(false)
    );

    for (let row = 0; row < grid.length; row++) {
        for (let col = 0; col < grid[0].length; col++) {
            if (grid[row][col] === 1 && !seen[row][col]) {
                // Perform DFS to count all servers in the current group
                const connectedServers = dfs(grid, row, col, seen);
                // If the group has more than 1 server, add it to the total count
                if (connectedServers > 1) {
                    cnt += connectedServers;
                }
            }
        }
    }

    return cnt;
};

/**
 * Perform DFS to count connected servers in the same row or column
 * @param {number[][]} grid
 * @param {number} row
 * @param {number} col
 * @param {boolean[][]} seen
 * @return {number}
 */
const dfs = (grid, row, col, seen) => {
    // If out of bounds or already visited, return 0
    if (
        row < 0 ||
        row >= grid.length ||
        col < 0 ||
        col >= grid[0].length ||
        seen[row][col] ||
        grid[row][col] === 0
    ) {
        return 0;
    }

    // Mark the current cell as seen
    seen[row][col] = true;

    // Initialize count for the current server
    let count = 1;

    // Explore all cells in the same row
    for (let c = 0; c < grid[0].length; c++) {
        if (c !== col) {
            count += dfs(grid, row, c, seen);
        }
    }

    // Explore all cells in the same column
    for (let r = 0; r < grid.length; r++) {
        if (r !== row) {
            count += dfs(grid, r, col, seen);
        }
    }

    return count;
};
