/**
 * @param {number[][]} grid
 * @return {number}
 */
var largestIsland = function (grid) {
    const n = grid.length;
    const directions = [[0, 1], [1, 0], [0, -1], [-1, 0]];

    let regionId = 2; // Start with 2 to avoid overlapping with grid values (1 and 0)
    const regionSize = new Map(); // Map to store region ID and its size
    const gridCopy = grid.map(row => row.slice()); // Create a copy of the grid for processing

    // DFS to find and label the regions
    const dfs = (r, c, id) => {
        let size = 1;
        gridCopy[r][c] = id; // Mark the current cell with the region ID
        for (const [dr, dc] of directions) {
            const nr = r + dr, nc = c + dc;
            if (nr >= 0 && nr < n && nc >= 0 && nc < n && gridCopy[nr][nc] === 1) {
                size += dfs(nr, nc, id);
            }
        }
        return size;
    };

    // Step 1: Label regions and calculate their sizes
    for (let r = 0; r < n; r++) {
        for (let c = 0; c < n; c++) {
            if (gridCopy[r][c] === 1) {
                const size = dfs(r, c, regionId);
                regionSize.set(regionId, size);
                regionId++;
            }
        }
    }

    let maxIslandSize = Math.max(...Array.from(regionSize.values())); // The size of the largest island without any change

    // Step 2: Try to change water cells to land and calculate the possible largest island size
    for (let r = 0; r < n; r++) {
        for (let c = 0; c < n; c++) {
            if (grid[r][c] === 0) { 
                const seenRegions = new Set(); // To avoid counting the same region twice
                let newIslandSize = 1; // Changing this cell to land (1)

                for (const [dr, dc] of directions) {
                    const nr = r + dr, nc = c + dc;
                    if (nr >= 0 && nr < n && nc >= 0 && nc < n && gridCopy[nr][nc] > 1) {
                        const region = gridCopy[nr][nc];
                        if (!seenRegions.has(region)) {
                            seenRegions.add(region);
                            newIslandSize += regionSize.get(region);
                        }
                    }
                }

                maxIslandSize = Math.max(maxIslandSize, newIslandSize);
            }
        }
    }

    return maxIslandSize;
};
