var shortestDistance = function(grid) {
    const m = grid.length;
    if (m === 0) return -1;
    const n = grid[0].length;

    const buildings = [];
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (grid[i][j] === 1) {
                buildings.push([i, j]);
            }
        }
    }

    const totalBuildings = buildings.length;
    if (totalBuildings === 0) return -1;

    const distances = Array.from({ length: m }, () => new Array(n).fill(0));
    const reach = Array.from({ length: m }, () => new Array(n).fill(0));

    const dirs = [[-1, 0], [1, 0], [0, -1], [0, 1]];

    for (const [x, y] of buildings) {
        const queue = [[x, y]];
        const visited = Array.from({ length: m }, () => new Array(n).fill(false));
        visited[x][y] = true;
        let level = 0;

        while (queue.length > 0) {
            const size = queue.length;
            for (let i = 0; i < size; i++) {
                const [currX, currY] = queue.shift();

                if (grid[currX][currY] === 0) {
                    distances[currX][currY] += level;
                    reach[currX][currY]++;
                }

                for (const [dx, dy] of dirs) {
                    const newX = currX + dx;
                    const newY = currY + dy;

                    if (newX >= 0 && newX < m && newY >= 0 && newY < n && !visited[newX][newY] && grid[newX][newY] === 0) {
                        visited[newX][newY] = true;
                        queue.push([newX, newY]);
                    }
                }
            }
            level++;
        }
    }

    let minDistance = Infinity;
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (grid[i][j] === 0 && reach[i][j] === totalBuildings) {
                minDistance = Math.min(minDistance, distances[i][j]);
            }
        }
    }

    return minDistance === Infinity ? -1 : minDistance;
};