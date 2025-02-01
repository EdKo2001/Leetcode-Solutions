/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number[]}
 */
var distinctNumbers = function (nums, k) {
    // const freqMap = new Map();
    // const res = new Array(nums.length - k + 1);

    // for (let i = 0; i < k; i++) {
    //     freqMap.set(nums[i], (freqMap.get(nums[i]) || 0) + 1);
    // }
    // res[0] = freqMap.size;

    // for (let i = k; i < nums.length; i++) {
    //     freqMap.set(nums[i], (freqMap.get(nums[i]) || 0) + 1);

    //     const oldElement = nums[i - k];
    //     freqMap.set(oldElement, freqMap.get(oldElement) - 1);
    //     if (freqMap.get(oldElement) === 0) {
    //         freqMap.delete(oldElement);
    //     }

    //     res[i - k + 1] = freqMap.size;
    // }

    // return res;

    const freqMap = new Map();
    const res = new Array(nums.length - k + 1);

    for (let i = 0; i < nums.length; i++) {
        freqMap.set(nums[i], (freqMap.get(nums[i]) || 0) + 1);

        if (i >= k - 1) {
            res[i - k + 1] = freqMap.size;

            const oldElement = nums[i - k + 1];
            freqMap.set(oldElement, freqMap.get(oldElement) - 1);
            if (freqMap.get(oldElement) === 0) {
                freqMap.delete(oldElement);
            }
        }
    }

    return res;
};
