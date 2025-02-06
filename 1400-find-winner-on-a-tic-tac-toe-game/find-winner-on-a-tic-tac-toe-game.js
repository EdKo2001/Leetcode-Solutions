/**
 * @param {number[][]} moves
 * @return {string}
 */
var tictactoe = function (moves) {
    const matrix = Array.from({ length: 3 }, () => new Array(3).fill(0));

    let turnA = true;
    for (const [row, col] of moves) {
        matrix[row][col] = turnA ? 1 : 2; // 1 for A, 2 for B
        turnA = !turnA;
    }

    const checkWinner = (player) => {
        // Check rows & columns
        for (let i = 0; i < 3; i++) {
            if (
                (matrix[i][0] === player && matrix[i][1] === player && matrix[i][2] === player) || // Row check
                (matrix[0][i] === player && matrix[1][i] === player && matrix[2][i] === player)    // Column check
            ) {
                return true;
            }
        }

        // Check diagonals
        if (
            (matrix[0][0] === player && matrix[1][1] === player && matrix[2][2] === player) || // Main diagonal
            (matrix[0][2] === player && matrix[1][1] === player && matrix[2][0] === player)   // Anti-diagonal
        ) {
            return true;
        }

        return false;
    };

    // Determine winner
    if (checkWinner(1)) return "A";
    if (checkWinner(2)) return "B";

    return moves.length === 9 ? "Draw" : "Pending";
};

// /**
//  * @param {number[][]} moves
//  * @return {string}
//  */
// var tictactoe = function (moves) {
//     const rowCount = Array(3).fill(0);
//     const colCount = Array(3).fill(0);
//     let diag1 = 0, diag2 = 0;

//     let turn = 1; // 1 for 'A', -1 for 'B'

//     for (const [row, col] of moves) {
//         rowCount[row] += turn;
//         colCount[col] += turn;

//         if (row === col) diag1 += turn;
//         if (row + col === 2) diag2 += turn;

//         // If any row, column, or diagonal reaches 3 (A wins) or -3 (B wins)
//         if (Math.abs(rowCount[row]) === 3 ||
//             Math.abs(colCount[col]) === 3 ||
//             Math.abs(diag1) === 3 ||
//             Math.abs(diag2) === 3) {
//             return turn === 1 ? "A" : "B";
//         }

//         turn *= -1; // Toggle turn
//     }

//     return moves.length === 9 ? "Draw" : "Pending";
// };

