/**
 * @param {number[]} nums
 * @return {boolean}
 */
var isArraySpecial = function (nums) {
    let parity = nums[0] % 2;
    for (let i = 1; i < nums.length; i++) {
        if (nums[i] % 2 === parity) return false;
        parity = 1 - parity;
    }
    return true;
};