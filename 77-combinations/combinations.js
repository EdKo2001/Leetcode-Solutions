/**
 * @param {number} n
 * @param {number} k
 * @return {number[][]}
 */
var combine = function (n, k) {
    const result = [];
    const backtrack = (start, path) => {
        if (path.length === k) {
            result.push([...path]);
            return;
        }
        for (let i = start; i <= n; i++) {
            path.push(i);          // Choose
            backtrack(i + 1, path); // Explore
            path.pop();            // Unchoose (backtrack)
        }
    };
    backtrack(1, []);
    return result;
};
