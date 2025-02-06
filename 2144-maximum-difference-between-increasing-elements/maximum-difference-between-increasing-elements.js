/**
 * @param {number[]} nums
 * @return {number}
 */
var maximumDifference = function (nums) {
    let maxDiff = -1;
    let minValue = nums[0];

    for (let i = 1; i < nums.length; i++) {
        if (nums[i] > minValue) {
            maxDiff = Math.max(maxDiff, nums[i] - minValue);
        } else {
            minValue = nums[i];
        }
    }

    return maxDiff;
};
