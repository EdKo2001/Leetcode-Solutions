/**
 * @param {string} blocks
 * @param {number} k
 * @return {number}
 */
var minimumRecolors = function (blocks, k) {
    let whites = 0;
    for (let i = 0; i < k; i++) {
        if (blocks[i] === "W") whites++;
    }

    let minOperations = whites;

    for (let i = k; i < blocks.length; i++) {
        if (blocks[i - k] === "W") whites--;
        if (blocks[i] === "W") whites++;
        minOperations = Math.min(minOperations, whites);
    }

    return minOperations;
};