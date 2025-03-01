/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permuteUnique = function (nums) {
    const n = nums.length;
    const ans = [];
    const visited = Array.from({ length: n }, () => false);

    nums.sort((a, b) => a - b);

    const backtracking = (arr) => {
        if (arr.length === n) return ans.push([...arr]);
        for (let i = 0; i < n; i++) {
           if (visited[i] || (i > 0 && nums[i] === nums[i - 1] && !visited[i - 1])) continue;
            arr.push(nums[i]);
            visited[i] = true;
            backtracking(arr);
            arr.pop();
            visited[i] = false;
        }
    }
    backtracking([]);
    return ans;
};