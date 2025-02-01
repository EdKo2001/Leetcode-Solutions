/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number[]}
 */
var distinctNumbers = function (nums, k) {
    const freqMap = new Map();
    const res = new Array(nums.length - k + 1);

    for (let i = 0; i < nums.length; i++) {
        const num = nums[i];

        freqMap.set(num, (freqMap.get(num) || 0) + 1);

        if (i >= k - 1) {
            res[i - k + 1] = freqMap.size;

            freqMap.set(nums[i - k + 1], freqMap.get(nums[i - k + 1]) - 1);
            if (freqMap.get(nums[i - k + 1]) === 0) {
                freqMap.delete(nums[i - k + 1]);
            }
        }
    }

    return res;
};