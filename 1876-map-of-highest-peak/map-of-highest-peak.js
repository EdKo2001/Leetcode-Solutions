var highestPeak = function (isWater) {
    const rows = isWater.length;
    const columns = isWater[0].length;

    // Large value to represent uninitialized heights
    const INF = rows * columns;

    // Initialize the cellHeights matrix with INF (unprocessed cells)
    const cellHeights = Array.from({ length: rows }, () =>
        Array(columns).fill(INF)
    );

    // Set the height of water cells to 0
    for (let row = 0; row < rows; row++) {
        for (let col = 0; col < columns; col++) {
            if (isWater[row][col] === 1) {
                cellHeights[row][col] = 0; // Water cells have height 0
            }
        }
    }

    // Function to check if a cell is within grid bounds
    const isValidCell = (row, col) =>
        row >= 0 && col >= 0 && row < rows && col < columns;

    // Forward pass: updating heights based on top and left neighbors
    for (let row = 0; row < rows; row++) {
        for (let col = 0; col < columns; col++) {
            let minNeighborDistance = INF;

            // Check the cell above
            const neighborRow = row - 1;
            const neighborCol = col;
            if (isValidCell(neighborRow, neighborCol)) {
                minNeighborDistance = Math.min(
                    minNeighborDistance,
                    cellHeights[neighborRow][neighborCol]
                );
            }

            // Check the cell to the left
            if (isValidCell(row, col - 1)) {
                minNeighborDistance = Math.min(
                    minNeighborDistance,
                    cellHeights[row][col - 1]
                );
            }

            // Update the current cell's height
            cellHeights[row][col] = Math.min(
                cellHeights[row][col],
                minNeighborDistance + 1
            );
        }
    }

    // Backward pass: updating heights based on bottom and right neighbors
    for (let row = rows - 1; row >= 0; row--) {
        for (let col = columns - 1; col >= 0; col--) {
            let minNeighborDistance = INF;

            // Check the cell below
            if (isValidCell(row + 1, col)) {
                minNeighborDistance = Math.min(
                    minNeighborDistance,
                    cellHeights[row + 1][col]
                );
            }

            // Check the cell to the right
            if (isValidCell(row, col + 1)) {
                minNeighborDistance = Math.min(
                    minNeighborDistance,
                    cellHeights[row][col + 1]
                );
            }

            // Update the current cell's height
            cellHeights[row][col] = Math.min(
                cellHeights[row][col],
                minNeighborDistance + 1
            );
        }
    }

    return cellHeights;
};
