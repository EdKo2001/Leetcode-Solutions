/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val === undefined ? 0 : val);
 *     this.left = (left === undefined ? null : left);
 *     this.right = (right === undefined ? null : right);
 * }
 */
/**
 * @param {number[]} nums
 * @return {TreeNode}
 */
var sortedArrayToBST = function (nums) {
    const constructTree = (start, end) => {
        if (start > end) return null; // Base case: no more elements to process

        const mid = Math.floor((start + end) / 2);
        const node = new TreeNode(nums[mid]); // Create the root node for this subarray

        // Recursively construct left and right subtrees
        node.left = constructTree(start, mid - 1);
        node.right = constructTree(mid + 1, end);

        return node; // Return the constructed tree
    };

    return constructTree(0, nums.length - 1); 
};
