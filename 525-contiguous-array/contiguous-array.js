/**
 * @param {number[]} nums
 * @return {number}
 */
var findMaxLength = function (nums) {
    let maxLen = 0;
    let freqMap = new Map();
    let balance = 0;

    freqMap.set(0, -1); // Edge case: Full subarray from index 0 to i

    for (let i = 0; i < nums.length; i++) {
        balance += nums[i] === 1 ? 1 : -1;

        if (freqMap.has(balance)) {
            maxLen = Math.max(maxLen, i - freqMap.get(balance));
        } else {
            freqMap.set(balance, i);
        }
    }

    return maxLen;
};
