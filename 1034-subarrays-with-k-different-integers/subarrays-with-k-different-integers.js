/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
// Approach 1: Sliding Window with Two Calls
function subarraysWithKDistinct(nums, k) {
    return slidingWindowAtMost(nums, k) - slidingWindowAtMost(nums, k - 1);
}

function slidingWindowAtMost(nums, k) {
    let left = 0, totalCount = 0;
    let freqMap = new Map();

    for (let right = 0; right < nums.length; right++) {
        freqMap.set(nums[right], (freqMap.get(nums[right]) || 0) + 1);
        
        while (freqMap.size > k) {
            freqMap.set(nums[left], freqMap.get(nums[left]) - 1);
            if (freqMap.get(nums[left]) === 0) {
                freqMap.delete(nums[left]);
            }
            left++;
        }
        
        totalCount += right - left + 1;
    }

    return totalCount;
}