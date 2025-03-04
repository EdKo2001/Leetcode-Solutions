/**
 * @param {character[][]} board
 * @param {string} word
 * @return {boolean}
 */
var exist = function (board, word) {
    const m = board.length;
    const n = board[0].length;
    const seen = Array.from({ length: m }, () => new Array(n).fill(false));

    const backtrack = (x, y, wordIndex) => {
        if (wordIndex === word.length) return true;
        if (x < 0 || x >= m || y < 0 || y >= n || seen[x][y] || board[x][y] !== word[wordIndex]) return false;

        const directions = [[1, 0], [-1, 0], [0, 1], [0, -1]];
        for (const [dx, dy] of directions) {
            seen[x][y] = true;
            if (backtrack(x + dx, y + dy, wordIndex + 1)) return true;
            seen[x][y] = false;
        }

        return false;
    }

    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (backtrack(i, j, 0)) return true;
        }
    }


    return false;
};