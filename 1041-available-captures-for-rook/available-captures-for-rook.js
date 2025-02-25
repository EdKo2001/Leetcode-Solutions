/**
 * @param {character[][]} board
 * @return {number}
 */
var numRookCaptures = function (board) {
    let cnt = 0;
    let rookX = -1, rookY = -1;

    // Find the Rook's position
    for (let i = 0; i < 8; i++) {
        for (let j = 0; j < 8; j++) {
            if (board[i][j] === 'R') {
                rookX = i;
                rookY = j;
                break;
            }
        }
        if (rookX !== -1) break;
    }

    // Directions: Up, Right, Down, Left
    const directions = [
        [-1, 0], [0, 1], [1, 0], [0, -1]
    ];

    for (let [dx, dy] of directions) {
        let x = rookX, y = rookY;
        while (true) {
            x += dx;
            y += dy;
            if (x < 0 || x >= 8 || y < 0 || y >= 8 || board[x][y] === 'B') break;
            if (board[x][y] === 'p') {
                cnt++;
                break;
            }
        }
    }

    return cnt;
};
