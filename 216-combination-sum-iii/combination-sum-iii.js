/**
 * @param {number} k
 * @param {number} n
 * @return {number[][]}
 */
var combinationSum3 = function (k, n) {
    const res = [];

    const backtracking = (arr, sum, start) => {
        if (sum === n && arr.length === k) {
            res.push([...arr]);
            return;
        }
        if (sum > n || arr.length === k) return;
        for (let i = start; i <= 9; i++) {
            arr.push(i);
            backtracking(arr, sum + i, i + 1);
            arr.pop();
        }
    }

    backtracking([], 0, 1);
    return res;
};