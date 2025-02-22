/**
 * @param {number[]} nums
 * @return {number}
 */
var findMaxConsecutiveOnes = function (nums) {
    let maxConsecutive = 0;
    let left = 0;
    let zeroIndex = -1;

    for (let right = 0; right < nums.length; right++) {
        if (nums[right] === 0) {
            if (zeroIndex !== -1) left = zeroIndex + 1;
            zeroIndex = right;
        }
        maxConsecutive = Math.max(maxConsecutive, right - left + 1);
    }

    return maxConsecutive;
};
