/**
 * @param {number[][]} grid
 * @param {number} x
 * @return {number}
 */
var minOperations = function (grid, x) {
    const elements = [];

    for (let i = 0; i < grid.length; i++) {
        for (let j = 0; j < grid[0].length; j++) {
            const element = grid[i][j];
            if (elements.length > 0 && element % x !== elements[0] % x) return -1;
            elements.push(element);
        }
    }

    elements.sort((a, b) => a - b);
    const target = elements[Math.floor(elements.length / 2)];

    let operations = 0;
    for (const num of elements) {
        operations += Math.abs(target - num) / x;
    }

    return operations;
};
