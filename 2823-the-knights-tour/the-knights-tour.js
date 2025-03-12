/**
 * @param {number} m
 * @param {number} n
 * @param {number} r
 * @param {number} c
 * @return {number[][]}
 */
var tourOfKnight = function (m, n, r, c) {
    const matrix = Array.from({ length: m }, () => new Array(n).fill(-1));
    const moves = [
        [-2, -1], [-2, 1], [2, -1], [2, 1],
        [-1, -2], [-1, 2], [1, -2], [1, 2]
    ];
    
    const backtrack = (x, y, moveCount) => {
        if (moveCount === m * n) return true; // Base case: board filled
        
        for (const [dx, dy] of moves) {
            const newX = x + dx, newY = y + dy;
            if (newX >= 0 && newX < m && newY >= 0 && newY < n && matrix[newX][newY] === -1) {
                matrix[newX][newY] = moveCount;
                if (backtrack(newX, newY, moveCount + 1)) return true;
                matrix[newX][newY] = -1; // Undo move
            }
        }
        
        return false;
    };

    matrix[r][c] = 0;
    backtrack(r, c, 1);
    
    return matrix;
};
