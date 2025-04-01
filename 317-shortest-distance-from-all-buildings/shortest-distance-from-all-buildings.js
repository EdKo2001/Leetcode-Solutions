/**
 * @param {number[][]} grid
 * @return {number}
 */
var shortestDistance = function(grid) {
    const m = grid.length, n = grid[0].length;
    const dist = Array.from({ length: m }, () => Array(n).fill(0));
    const reach = Array.from({ length: m }, () => Array(n).fill(0));
    let totalBuildings = 0;
    const directions = [[1, 0], [-1, 0], [0, 1], [0, -1]];

    // Count total buildings and perform BFS from each building
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (grid[i][j] === 1) {
                totalBuildings++;
                const queue = [[i, j, 0]]; // x, y, current distance
                const visited = Array.from({ length: m }, () => Array(n).fill(false));
                visited[i][j] = true;

                while (queue.length) {
                    const [x, y, d] = queue.shift();
                    for (const [dx, dy] of directions) {
                        const nx = x + dx, ny = y + dy;
                        if (
                            nx >= 0 && nx < m &&
                            ny >= 0 && ny < n &&
                            !visited[nx][ny] &&
                            grid[nx][ny] === 0
                        ) {
                            visited[nx][ny] = true;
                            dist[nx][ny] += d + 1;
                            reach[nx][ny]++;
                            queue.push([nx, ny, d + 1]);
                        }
                    }
                }
            }
        }
    }

    // Find the minimum distance from an empty land that can reach all buildings.
    let ans = Infinity;
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (grid[i][j] === 0 && reach[i][j] === totalBuildings) {
                ans = Math.min(ans, dist[i][j]);
            }
        }
    }

    return ans === Infinity ? -1 : ans;
};
