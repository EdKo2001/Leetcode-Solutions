/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var maxSubArrayLen = function (nums, k) {
    const prefixSumIndex = new Map();
    let sum = 0;
    let maxLen = 0;

    for (let i = 0; i < nums.length; i++) {
        sum += nums[i];

        if (sum === k) {
            maxLen = i + 1;
        }

        if (prefixSumIndex.has(sum - k)) {
            maxLen = Math.max(maxLen, i - prefixSumIndex.get(sum - k));
        }

        if (!prefixSumIndex.has(sum)) {
            prefixSumIndex.set(sum, i);
        }
    }

    return maxLen;
};