/**
 * @param {character[][]} grid
 * @return {number}
 */
var getFood = function (grid) {
    const rows = grid.length;
    const cols = grid[0].length;

    const directions = [[1, 0], [-1, 0], [0, 1], [0, -1]];
    const queue = [];
    const visited = new Array(rows).fill(null).map(() => new Array(cols).fill(false));

    // Find the starting point ('*') and enqueue it
    for (let i = 0; i < rows; i++) {
        for (let j = 0; j < cols; j++) {
            if (grid[i][j] === "*") {
                queue.push([i, j, 0]); // [row, col, steps]
                visited[i][j] = true;
                break;
            }
        }
    }

    // BFS to find the shortest path to food ('#')
    while (queue.length > 0) {
        const [row, col, steps] = queue.shift();

        // If we find food, return the steps
        if (grid[row][col] === "#") {
            return steps;
        }

        // Explore all valid neighbors
        for (const [dx, dy] of directions) {
            const newRow = row + dx;
            const newCol = col + dy;

            // Check if the cell is within bounds, not visited, and not blocked
            if (
                newRow >= 0 && newRow < rows &&
                newCol >= 0 && newCol < cols &&
                grid[newRow][newCol] !== "X" &&
                !visited[newRow][newCol]
            ) {
                queue.push([newRow, newCol, steps + 1]);
                visited[newRow][newCol] = true;
            }
        }
    }

    // If no path to food is found, return -1
    return -1;
};
