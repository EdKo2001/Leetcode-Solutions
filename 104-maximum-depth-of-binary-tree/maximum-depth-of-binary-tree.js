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
 * @return {number}
 */
var maxDepth = function (root) {
    return traverse(root, 0);
};

const traverse = (node, depth) => {
    if (!node) return depth;

    let max = 0;

    max = Math.max(max, traverse(node.left, depth + 1));
    max = Math.max(max, traverse(node.right, depth + 1));

    return max;
}