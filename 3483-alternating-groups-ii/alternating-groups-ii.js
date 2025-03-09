/**
 * @param {number[]} colors
 * @param {number} k
 * @return {number}
 */
var numberOfAlternatingGroups = function(colors, k) {
    let length = colors.length;
    let result = 0;
    
    // Length of current alternating sequence
    let alternatingElementsCount = 1;
    let lastColor = colors[0];

    // Loop through array with circular traversal
    for (let i = 1; i < length + k - 1; i++) {
        let index = i % length; // Wrap around using modulo

        // Check if current color is the same as the last color
        if (colors[index] === lastColor) {
            // Pattern breaks, reset sequence length
            alternatingElementsCount = 1;
            lastColor = colors[index];
            continue;
        }

        // Extend alternating sequence
        alternatingElementsCount++;

        // If sequence length reaches at least k, count it
        if (alternatingElementsCount >= k) {
            result++;
        }

        lastColor = colors[index];
    }

    return result;
};