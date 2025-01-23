/**
 * @param {number[][]} grid
 * @return {number}
 */
var countServers = function (grid) {
    let rows = grid.length;
    let cols = grid[0].length;

    // Count servers in each row and column
    let rowCount = new Array(rows).fill(0);
    let colCount = new Array(cols).fill(0);

    // First pass to calculate the counts
    for (let row = 0; row < rows; row++) {
        for (let col = 0; col < cols; col++) {
            if (grid[row][col] === 1) {
                rowCount[row]++;
                colCount[col]++;
            }
        }
    }

    // Second pass to count servers that can communicate
    let cnt = 0;
    for (let row = 0; row < rows; row++) {
        for (let col = 0; col < cols; col++) {
            if (grid[row][col] === 1 && (rowCount[row] > 1 || colCount[col] > 1)) {
                cnt++;
            }
        }
    }

    return cnt;
};
