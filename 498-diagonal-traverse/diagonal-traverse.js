/**
 * @param {number[][]} mat
 * @return {number[]}
 */
var findDiagonalOrder = function (mat) {
    if (!mat || !mat.length || !mat[0].length) return [];

    let diagonals = {};
    let rows = mat.length, cols = mat[0].length;

    for (let r = 0; r < rows; r++) {
        for (let c = 0; c < cols; c++) {
            let key = r + c;
            if (!diagonals[key]) diagonals[key] = [];
            diagonals[key].push(mat[r][c]);
        }
    }

    let result = [];
    Object.keys(diagonals).forEach(key => {
        let values = diagonals[key];
        if (key % 2 === 0) values.reverse();
        result.push(...values);
    });

    return result;
};
