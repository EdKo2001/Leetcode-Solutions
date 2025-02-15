/**
 * @param {number[][]} mat
 * @return {number[][]}
 */
var diagonalSort = function (mat) {
    let rows = mat.length, cols = mat[0].length;

    // Sorting diagonals starting from first column (left edge)
    for (let i = 0; i < rows; i++) {
        let temp = [];
        let len = Math.min(rows - i, cols); // Diagonal length
        for (let j = 0; j < len; j++) {
            temp.push(mat[i + j][j]);
        }
        temp.sort((a, b) => a - b);
        for (let j = 0; j < len; j++) {
            mat[i + j][j] = temp[j];
        }
    }

    // Sorting diagonals starting from first row (top edge), excluding (0,0)
    for (let j = 1; j < cols; j++) {
        let temp = [];
        let len = Math.min(rows, cols - j);
        for (let i = 0; i < len; i++) {
            temp.push(mat[i][j + i]);
        }
        temp.sort((a, b) => a - b);
        for (let i = 0; i < len; i++) {
            mat[i][j + i] = temp[i];
        }
    }

    return mat;
};
