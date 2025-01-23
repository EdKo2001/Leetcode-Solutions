/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @param {number} k
 * @return {number}
 */
var kthSmallest = function (root, k) {
    const stack = [];
    let current = root;

    while (current || stack.length) {
        // Traverse the left subtree
        while (current) {
            stack.push(current);
            current = current.left;
        }

        // Process the node
        current = stack.pop();
        k -= 1;

        // If we reach the kth smallest element
        if (k === 0) return current.val;

        // Traverse the right subtree
        current = current.right;
    }

    return null; // This line is just a safety net; it won't be reached if k is valid.
};
