/**
 * @param {string} s
 * @return {string[]}
 */
var restoreIpAddresses = function (s) {
    const result = [];

    function backtrack(start, path) {
        // Base case: If we have 4 segments and we've used all characters in the string
        if (path.length === 4 && start === s.length) {
            result.push(path.join('.'));
            return;
        }

        // If we already have 4 segments but haven't used all characters, stop
        if (path.length === 4) {
            return;
        }

        // Try all possible segment lengths (1 to 3)
        for (let len = 1; len <= 3; len++) {
            if (start + len > s.length) break; // Don't go out of bounds

            const segment = s.slice(start, start + len);

            // Validate the segment
            if (
                (segment.length > 1 && segment[0] === '0') || // Leading zero
                parseInt(segment) > 255 // Out of range
            ) {
                continue;
            }

            // Add segment to path and backtrack
            path.push(segment);
            backtrack(start + len, path);

            // Remove the last segment to backtrack
            path.pop();
        }
    }

    backtrack(0, []);
    return result;
};