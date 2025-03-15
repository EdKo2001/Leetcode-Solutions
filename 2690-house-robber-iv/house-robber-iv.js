/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var minCapability = function(nums, k) {
    let left = Math.min(...nums), right = Math.max(...nums);
    
    const canRob = (cap) => {
        let count = 0, i = 0;
        while (i < nums.length) {
            if (nums[i] <= cap) {
                count++;
                i++; // Skip next house to maintain non-adjacency
            }
            i++;
        }
        return count >= k;
    };

    while (left < right) {
        let mid = Math.floor((left + right) / 2);
        if (canRob(mid)) {
            right = mid; // Try to minimize capability
        } else {
            left = mid + 1;
        }
    }
    
    return left;
};
