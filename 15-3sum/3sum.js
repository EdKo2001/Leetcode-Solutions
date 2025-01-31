/**
 * @param {number[]} nums
 * @return {number[][]}
 */
function threeSum(nums) {
    nums.sort((a, b) => a - b);
    const result = new Set();

    for (let i = 0; i < nums.length - 2; i++) {
        if (i > 0 && nums[i] === nums[i - 1]) continue;

        const target = -nums[i];
        const pairs = twoSum(nums, i + 1, target);

        for (const [num1, num2] of pairs) {
            result.add(JSON.stringify([nums[i], num1, num2])); // Store as a string to avoid duplicates
        }
    }

    return Array.from(result, JSON.parse); // Convert back to array
}

function twoSum(nums, start, target) {
    const map = new Map();
    const pairs = [];

    for (let i = start; i < nums.length; i++) {
        const complement = target - nums[i];

        if (map.has(complement)) {
            pairs.push([complement, nums[i]]);
        }

        map.set(nums[i], i);
    }

    return pairs;
}
