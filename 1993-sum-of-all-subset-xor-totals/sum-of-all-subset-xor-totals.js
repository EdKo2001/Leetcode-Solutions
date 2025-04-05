/**
 * @param {number[]} nums
 * @return {number}
 */
var subsetXORSum = function(nums) {
    let result = 0;

    // Helper function to generate subsets recursively
    function backtrack(index, currentXOR) {
        // Base case: reached the end of the array
        if (index === nums.length) {
            result += currentXOR; // Add current XOR total to the result
            return;
        }

        // Include the current element in the subset
        backtrack(index + 1, currentXOR ^ nums[index]);

        // Exclude the current element from the subset
        backtrack(index + 1, currentXOR);
    }

    // Start backtracking from the first element
    backtrack(0, 0);

    return result;
};