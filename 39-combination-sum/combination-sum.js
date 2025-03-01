/**
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */
var combinationSum = function (candidates, target) {
    const res = [];
    const backtracking = (i, arr, sum) => {
        if (sum === target) return res.push([...arr]);
        if (sum > target) return;
        for (let start = i; start < candidates.length; start++) {
            const candidate = candidates[start];
            arr.push(candidate);
            backtracking(start, arr, sum + candidate);
            arr.pop();
        }
    }
    backtracking(0, [], 0);
    return res;
};