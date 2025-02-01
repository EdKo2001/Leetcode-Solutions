/**
 * @param {number[]} nums
 * @return {boolean}
 */
var isArraySpecial = function (nums) {
    // if (nums.length <= 1) return true; 
    // let parity = nums[0] % 2;
    // for (let i = 1; i < nums.length; i++) {
    //     if (nums[i] % 2 === parity) return false;
    //     parity = 1 - parity;
    // }
    // return true;

    if (nums.length <= 1) return true;

    for (let i = 1; i < nums.length; i++) {
        if (nums[i] % 2 === nums[i - 1] % 2) return false;
    }

    return true;
};