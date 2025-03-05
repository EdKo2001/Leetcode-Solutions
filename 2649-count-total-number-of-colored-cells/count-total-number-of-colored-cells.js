/**
 * @param {number} n
 * @return {number}
 */
var coloredCells = function (n) {
    let numBlueCells = 1;
    let addend = 4;

    // Iterate n - 1 times
    while (--n > 0) {
        // Add and update current multiple of 4
        numBlueCells += addend;
        addend += 4;
    }

    return numBlueCells;
};