/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var minOperations = function (nums, k) {
    const set = new Set();
    for (const x of nums) {
        if (x < k) {
            return -1;
        } else if (x > k) {
            set.add(x);
        }
    }
    return set.size;
};