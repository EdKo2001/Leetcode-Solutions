/**
 * @param {string} tiles
 * @return {number}
 */
var numTilePossibilities = function (tiles) {
    const sortedTiles = tiles.split("").sort(); // Sorting to handle duplicates
    const visited = new Array(tiles.length).fill(false);
    let count = 0;

    const backtracking = () => {
        for (let i = 0; i < sortedTiles.length; i++) {
            if (visited[i]) continue;
            if (i > 0 && sortedTiles[i] === sortedTiles[i - 1] && !visited[i - 1]) continue; // Skip duplicate choices

            visited[i] = true;
            count++;
            backtracking();
            visited[i] = false;
        }
    };

    backtracking();
    return count;
};
