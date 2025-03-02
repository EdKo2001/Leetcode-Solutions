/**
 * @param {number[]} nums
 * @param {number} k
 * @return {boolean}
 */
var containsNearbyDuplicate = function (nums, k) {
    const seen = new Map();
    for (let i = 0; i < nums.length; i++) {
        const num = nums[i];
        if (seen.has(num) && i - seen.get(num) <= k) return true;
        seen.set(num, i);
        
        // Remove elements that are too far in the past
        if (i >= k) {
            seen.delete(nums[i - k]);
        }
    }
    return false;
};
