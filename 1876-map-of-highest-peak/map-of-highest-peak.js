/**
 * @param {number[][]} isWater
 * @return {number[][]}
 */
var highestPeak = function (isWater) {
    let n = isWater.length;
    let m = isWater[0].length;

    const queue = new Array(n * m);
    let front = 0, rear = 0;

    for (let i = 0; i < n; i++) {
        for (let j = 0; j < m; j++) {
            if (isWater[i][j] === 1) {
                queue[rear++] = [i, j];
                isWater[i][j] = 0;
            } else {
                isWater[i][j] = -1;
            }
        }
    }

    const directions = [[1, 0], [0, 1], [-1, 0], [0, -1]];

    while (front < rear) {
        const [x, y] = queue[front++];

        for (const [dx, dy] of directions) {
            const newRow = x + dx;
            const newCol = y + dy;

            if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && isWater[newRow][newCol] === -1) {
                isWater[newRow][newCol] = isWater[x][y] + 1;
                queue[rear++] = [newRow, newCol];
            }
        }
    }

    return isWater;
};
