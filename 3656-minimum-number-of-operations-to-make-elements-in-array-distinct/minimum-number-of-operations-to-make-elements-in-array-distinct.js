/**
 * @param {number[]} nums
 * @return {number}
 */
var minimumOperations = function (nums) {
    let ans = 0;
    for (let i = 0; i < nums.length; i += 3, ans++) {
        if (checkUnique(nums, i)) {
            return ans;
        }
    }
    return ans;
};

const checkUnique = (nums, start) => {
    let seen = new Set();
    for (let i = start; i < nums.length; i++) {
        if (seen.has(nums[i])) {
            return false;
        }
        seen.add(nums[i]);
    }
    return true;
};