/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permute = function (nums) {
    const n = nums.length;
    const res = [];
    const used = new Array(nums.length).fill(false);

    const backtracking = (arr) => {
        if (arr.length === n) {
            res.push([...arr]);
            return;
        }
        for (let i = 0; i < n; i++) {
            if (used[i]) continue;
            arr.push(nums[i]);
            used[i] = true;
            backtracking(arr);
            arr.pop();
            used[i] = false;;
        }
    }

    backtracking([]);
    return res;
};