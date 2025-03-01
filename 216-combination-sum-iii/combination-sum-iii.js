/**
 * @param {number} k
 * @param {number} n
 * @return {number[][]}
 */
var combinationSum3 = function (k, n) {
    const ans = [];
    const backtracking = (start, sum, arr) => {
        if (arr.length === k && sum === n) return ans.push([...arr]);
        if (arr.length >= k || sum >= n) return;
        for (let i = start; i <= 9; i++) {
            arr.push(i);
            backtracking(i + 1, sum + i, arr);
            arr.pop();
        }
    }
    backtracking(1, 0, []);
    return ans;
};