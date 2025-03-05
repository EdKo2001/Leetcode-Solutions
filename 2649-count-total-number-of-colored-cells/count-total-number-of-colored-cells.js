/**
 * @param {number} n
 * @return {number}
 */
var coloredCells = function (n) {
    let numBlueCells = 1;
    let added = 4;

    // Iterate n - 1 times
    while (--n > 0) {
        // Add and update current multiple of 4
        numBlueCells += added;
        added += 4;
    }

    return numBlueCells;
};