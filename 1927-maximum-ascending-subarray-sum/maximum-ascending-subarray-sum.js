/**
 * @param {number[]} nums
 * @return {number}
 */
var maxAscendingSum = function (nums) {
    let maxSum = nums[0];
    let currSum = nums[0];

    for (let i = 1; i < nums.length; i++) {
        if (nums[i] > nums[i - 1]) {
            currSum += nums[i];
            maxSum = Math.max(maxSum, currSum);
        } else {
            currSum = nums[i];
        }
    }

    return Math.max(maxSum, currSum);
};