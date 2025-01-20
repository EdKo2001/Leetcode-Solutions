/**
 * @param {number[]} arr
 * @param {number[][]} mat
 * @return {number}
 */
var firstCompleteIndex = function (arr, mat) {
    const m = mat.length;
    const n = mat[0].length;

    const rowFreq = new Array(m).fill(0);
    const colFreq = new Array(n).fill(0);

    const positionMap = new Map();
    for (let row = 0; row < m; row++) {
        for (let col = 0; col < n; col++) {
            positionMap.set(mat[row][col], [row, col]);
        }
    }

    for (let i = 0; i < arr.length; i++) {
        const [row, col] = positionMap.get(arr[i]);
        rowFreq[row]++;
        colFreq[col]++;

        if (rowFreq[row] === n || colFreq[col] === m) {
            return i;
        }
    }

    return -1;
};
