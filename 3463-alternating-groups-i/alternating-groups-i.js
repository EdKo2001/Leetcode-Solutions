/**
 * @param {number[]} colors
 * @return {number}
 */
var numberOfAlternatingGroups = function (colors) {
    let n = colors.length;
    let count = 0;

    for (let i = 0; i < n; i++) {
        let prev = colors[(i - 1 + n) % n]; // Left neighbor (handling circular case)
        let curr = colors[i];               // Middle element
        let next = colors[(i + 1) % n];     // Right neighbor (handling circular case)

        if (prev !== curr && curr !== next) {
            count++;
        }
    }

    return count;
};
