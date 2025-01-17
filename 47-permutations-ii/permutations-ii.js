/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permuteUnique = function (nums) {
    const res = [];
    const n = nums.length;
    nums.sort((a, b) => a - b); // Sort the array to handle duplicates
    const used = Array(n).fill(false); // Track used elements

    const backtracking = (arr) => {
        // Base case: If the permutation is complete
        if (arr.length === n) {
            res.push([...arr]); // Push a copy of the current permutation
            return;
        }

        // Iterate through all numbers
        for (let i = 0; i < n; i++) {
            // Skip duplicates
            if (i > 0 && nums[i] === nums[i - 1] && !used[i - 1]) continue;

            // Skip if the number is already used
            if (used[i]) continue;

            // Mark the number as used
            used[i] = true;

            // Include the current number in the permutation
            arr.push(nums[i]);


            // Recur with the updated permutation
            backtracking(arr);

            // Backtrack: Remove the last number and mark it as unused
            arr.pop();
            used[i] = false;
        }
    };

    backtracking([]);
    return res;
};
