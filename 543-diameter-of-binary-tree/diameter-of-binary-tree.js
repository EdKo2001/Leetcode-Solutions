/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val);
 *     this.left = (left===undefined ? null : left);
 *     this.right = (right===undefined ? null : right);
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */
var diameterOfBinaryTree = function (root) {
    let maxDiameter = 0;

    const dfs = (node) => {
        if (!node) return 0;

        // Recursively find the height of the left and right subtrees
        const leftHeight = dfs(node.left);
        const rightHeight = dfs(node.right);

        // Update the global diameter (leftHeight + rightHeight is the potential diameter at this node)
        maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);

        // Return the height of the current node
        return 1 + Math.max(leftHeight, rightHeight);
    };

    dfs(root);
    return maxDiameter;
};
