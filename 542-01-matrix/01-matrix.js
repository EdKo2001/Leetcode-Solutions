/**
 * @param {number[][]} mat
 * @return {number[][]}
 */
var updateMatrix = function (mat) {
    const n = mat.length;
    const m = mat[0].length;
    const res = new Array(n).fill().map(() => new Array(m).fill(0));
    const queue = [];
    const seen = new Array(n).fill().map(() => new Array(m).fill(false));

    for (let i = 0; i < n; i++) {
        for (let j = 0; j < m; j++) {
            if (mat[i][j] === 0) {
                queue.push([i, j, 0]);
                seen[i][j] = true;
            }
        }
    }

    const directions = [[0, 1], [1, 0], [0, -1], [-1, 0]];
    while (queue.length > 0) {
        const node = queue.shift();
        const row = node[0];
        const col = node[1];
        const steps = node[2];
        for (const dir of directions) {
            const nextRow = row + dir[0];
            const nextCol = col + dir[1];
            if (0 <= nextRow && nextRow < n && 0 <= nextCol && nextCol < m && !seen[nextRow][nextCol]) {
                seen[nextRow][nextCol] = true;
                queue.push([nextRow, nextCol, steps + 1]);
                res[nextRow][nextCol] = steps + 1;
            }
        }
    }

    return res;
};