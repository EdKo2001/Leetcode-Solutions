/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var maximumSubarraySum = function (nums, k) {
    const freqMap = new Map();
    let maxSum = 0;
    let currSum = 0;

    for (let i = 0; i < k; i++) {
        const num = nums[i];
        freqMap.set(num, (freqMap.get(num) || 0) + 1);
        currSum += num;
    }

    if (freqMap.size === k) maxSum = Math.max(maxSum, currSum);

    for (let i = k; i < nums.length; i++) {
        const num = nums[i];
        freqMap.set(num, (freqMap.get(num) || 0) + 1);
        currSum += num;

        const old = nums[i - k];
        freqMap.set(old, (freqMap.get(old) || 0) - 1);
        if (freqMap.get(old) === 0) freqMap.delete(old);
        currSum -= old;

        if (freqMap.size === k) maxSum = Math.max(maxSum, currSum);
    }

    return maxSum;
};