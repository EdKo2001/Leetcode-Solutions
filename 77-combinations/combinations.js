/**
 * @param {number} n
 * @param {number} k
 * @return {number[][]}
 */
var combine = function (n, k) {
    const arr = [];
    const generate = (curr, prev) => {
        if (curr.length == k) return arr.push(curr);
        for (let i = 1; i <= n; i++) {
            if (i <= prev) continue;
            generate([...curr, i], i);
        }
    }
    generate([], null);
    return arr;
};