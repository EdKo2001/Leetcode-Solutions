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

// Optimized Simulation (O(1) Extra Space)
// var findDiagonalOrder = function (mat) {
//     if (!mat || !mat.length || !mat[0].length) return [];

//     let rows = mat.length, cols = mat[0].length;
//     let result = new Array(rows * cols);
//     let r = 0, c = 0, up = true;

//     for (let i = 0; i < rows * cols; i++) {
//         result[i] = mat[r][c];

//         if (up) {
//             if (c === cols - 1) { // Reached right boundary
//                 r++;
//                 up = false;
//             } else if (r === 0) { // Reached top boundary
//                 c++;
//                 up = false;
//             } else {
//                 r--;
//                 c++;
//             }
//         } else {
//             if (r === rows - 1) { // Reached bottom boundary
//                 c++;
//                 up = true;
//             } else if (c === 0) { // Reached left boundary
//                 r++;
//                 up = true;
//             } else {
//                 r++;
//                 c--;
//             }
//         }
//     }

//     return result;
// };
