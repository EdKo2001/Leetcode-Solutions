/**
 * @param {character[][]} board
 * @param {string} word
 * @return {boolean}
 */
// var exist = function (board, word) {
//     const m = board.length;
//     const n = board[0].length;
//     const seen = Array.from({ length: m }, () => new Array(n).fill(false));

//     const backtrack = (x, y, wordIndex) => {
//         if (wordIndex === word.length) return true; // Found the word
//         if (x < 0 || x >= m || y < 0 || y >= n || seen[x][y] || board[x][y] !== word[wordIndex]) return false;

//         seen[x][y] = true; // Mark as visited

//         const directions = [[1, 0], [-1, 0], [0, 1], [0, -1]];
//         for (const [dx, dy] of directions) {
//             if (backtrack(x + dx, y + dy, wordIndex + 1)) return true;
//         }

//         seen[x][y] = false; // Unmark after all paths are checked (backtracking)
//         return false;
//     };

//     for (let i = 0; i < m; i++) {
//         for (let j = 0; j < n; j++) {
//             if (backtrack(i, j, 0)) return true;
//         }
//     }

//     return false;
// };


var exist = function (board, word) {
    const m = board.length;
    const n = board[0].length;

    const backtrack = (x, y, wordIndex) => {
        if (wordIndex === word.length) return true;
        if (x < 0 || x >= m || y < 0 || y >= n || board[x][y] !== word[wordIndex]) return false;

        const temp = board[x][y];
        board[x][y] = "#"; // Mark visited

        const directions = [[1, 0], [-1, 0], [0, 1], [0, -1]];
        for (const [dx, dy] of directions) {
            if (backtrack(x + dx, y + dy, wordIndex + 1)) return true;
        }

        board[x][y] = temp; // Restore original character (backtracking)
        return false;
    };

    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (backtrack(i, j, 0)) return true;
        }
    }

    return false;
};