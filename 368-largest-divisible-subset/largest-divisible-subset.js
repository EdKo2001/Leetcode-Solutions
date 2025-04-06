/**
 * @param {number[]} nums
 * @return {number[]}
 */
var largestDivisibleSubset = function (nums) {
    nums.sort((a, b) => a - b);
    const n = nums.length;
    const groupSize = new Array(n).fill(1);
    const prevElement = new Array(n).fill(-1);
    let maxIndex = 0;

    for (let i = 0; i < n; i++) {
        for (let j = 0; j < i; j++) {
            if (nums[i] % nums[j] === 0 && groupSize[i] < groupSize[j] + 1) {
                groupSize[i] = groupSize[j] + 1;
                prevElement[i] = j;
            }
        }
        if (groupSize[i] > groupSize[maxIndex]) {
            maxIndex = i;
        }
    }

    const result = [];
    for (let i = maxIndex; i !== -1; i = prevElement[i]) {
        result.unshift(nums[i]);
    }

    return result;
};