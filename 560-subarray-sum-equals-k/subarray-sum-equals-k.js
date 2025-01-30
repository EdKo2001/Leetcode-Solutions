/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var subarraySum = function (nums, k) {
    let cnt = 0;
    const prefixSumMap = new Map();

    prefixSumMap.set(0, 1);
    let currSum = 0;

    for (let i = 0; i < nums.length; i++) {
        currSum += nums[i];

        if (prefixSumMap.has(currSum - k)) {
            cnt += prefixSumMap.get(currSum - k);
        }

        prefixSumMap.set(currSum, (prefixSumMap.get(currSum) || 0) + 1);
    }

    return cnt;
};
