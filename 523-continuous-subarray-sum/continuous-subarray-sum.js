/**
 * Checks if the array has a continuous subarray of size at least two 
 * that sums up to a multiple of k.
 * 
 * @param {number[]} nums - The input array of integers.
 * @param {number} k - The integer to check the sum multiple against.
 * @return {boolean} - Returns true if such a subarray exists, otherwise false.
 */
var checkSubarraySum = function (nums, k) {
    // Initialize the sum and a map to store the first occurrence of remainders.
    let sum = 0;
    const remainderMap = new Map();
    remainderMap.set(0, -1); // Initialize the map with remainder 0 at index -1.

    // Loop through the array.
    for (let i = 0; i < nums.length; i++) {
        sum += nums[i]; // Increment the sum by the current element.

        // Calculate the remainder of the sum with respect to k.
        const remainder = sum % k;

        // Adjust remainder to be non-negative.
        const adjustedRemainder = remainder < 0 ? remainder + k : remainder;

        // If the remainder has been seen before.
        if (remainderMap.has(adjustedRemainder)) {
            // Check if the subarray length is at least 2.
            if (i - remainderMap.get(adjustedRemainder) > 1) {
                return true; // Valid subarray found.
            }
        } else {
            // Store the first occurrence of the remainder.
            remainderMap.set(adjustedRemainder, i);
        }
    }

    return false; // No valid subarray found.
};