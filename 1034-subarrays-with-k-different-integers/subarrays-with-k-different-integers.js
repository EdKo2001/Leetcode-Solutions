/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
// Approach 1: Sliding Window with Two Calls

// Time Complexity:
// The function slidingWindowAtMost(nums, k) runs O(n).
// Since we call it twice (once for k and once for k-1), the overall time complexity is O(2n) = O(n).

// Space Complexity:
// The freqMap can store at most k elements at any time, so it takes O(k) space.
// Overall, the space complexity is O(k).

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

// Approach 2: Sliding Window in One Pass

// Time Complexity:
// We maintain a single sliding window and adjust left dynamically.
// Each element is processed at most twice (once when added, once when removed).
// Therefore, the complexity remains O(n).

// Space Complexity:
// The freqMap stores at most k distinct elements at any time, leading to O(k) space complexity.
// Overall, it is O(k).

// function subarraysWithKDistinct(nums, k) {
//     let left = 0, right = 0, totalCount = 0, currCount = 0;
//     let freqMap = new Map();

//     while (right < nums.length) {
//         // Add current element to the frequency map
//         freqMap.set(nums[right], (freqMap.get(nums[right]) || 0) + 1);

//         if (freqMap.get(nums[right]) === 1) k--; // New distinct element
        
//         // If we exceed k distinct elements, shrink the window
//         if (k < 0) {
//             freqMap.set(nums[left], freqMap.get(nums[left]) - 1);
//             if (freqMap.get(nums[left]) === 0) {
//                 freqMap.delete(nums[left]);
//             }
//             left++;
//             k++;
//             currCount = 0;
//         }

//         // If we have exactly k distinct elements, count subarrays
//         if (k === 0) {
//             while (freqMap.get(nums[left]) > 1) {
//                 freqMap.set(nums[left], freqMap.get(nums[left]) - 1);
//                 left++;
//                 currCount++;
//             }
//             totalCount += currCount + 1;
//         }

//         right++;
//     }

//     return totalCount;
// }
