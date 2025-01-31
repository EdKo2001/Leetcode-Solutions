/**
 * @param {number[]} nums
 * @return {number[][]}
 */
// function threeSum(nums) {
//     nums.sort((a, b) => a - b);
//     const result = new Set();

//     for (let i = 0; i < nums.length - 2; i++) {
//         if (i > 0 && nums[i] === nums[i - 1]) continue;

//         const target = -nums[i];
//         const pairs = twoSum(nums, i + 1, target);

//         for (const [num1, num2] of pairs) {
//             result.add(JSON.stringify([nums[i], num1, num2])); // Store as a string to avoid duplicates
//         }
//     }

//     return Array.from(result, JSON.parse); // Convert back to array
// }

// function twoSum(nums, start, target) {
//     const map = new Map();
//     const pairs = [];

//     for (let i = start; i < nums.length; i++) {
//         const complement = target - nums[i];

//         if (map.has(complement)) {
//             pairs.push([complement, nums[i]]);
//         }

//         map.set(nums[i], i);
//     }

//     return pairs;
// }

function threeSum(nums) {
    nums.sort((a, b) => a - b); // Sorting helps eliminate duplicates efficiently
    const result = [];

    for (let i = 0; i < nums.length - 2; i++) {
        if (i > 0 && nums[i] === nums[i - 1]) continue; // Skip duplicates

        let left = i + 1, right = nums.length - 1;
        while (left < right) {
            const sum = nums[i] + nums[left] + nums[right];

            if (sum === 0) {
                result.push([nums[i], nums[left], nums[right]]);
                left++;
                right--;

                while (left < right && nums[left] === nums[left - 1]) left++; // Skip duplicates
                while (left < right && nums[right] === nums[right + 1]) right--; // Skip duplicates
            } else if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }
    }

    return result;
}
