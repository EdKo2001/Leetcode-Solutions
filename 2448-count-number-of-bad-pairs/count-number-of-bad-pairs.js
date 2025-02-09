/**
 * @param {number[]} nums
 * @return {number}
 */
var countBadPairs = function (nums) {
    let n = nums.length;
    let totalPairs = (n * (n - 1)) / 2;
    let goodPairs = 0;
    let freq = new Map();

    for (let i = 0; i < n; i++) {
        let newVal = nums[i] - i;
        
        if (freq.has(newVal)) {
            goodPairs += freq.get(newVal);
            freq.set(newVal, freq.get(newVal) + 1);
        } else {
            freq.set(newVal, 1);
        }
    }

    return totalPairs - goodPairs;
};
