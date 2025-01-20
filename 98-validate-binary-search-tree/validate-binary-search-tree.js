/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val === undefined ? 0 : val);
 *     this.left = (left === undefined ? null : left);
 *     this.right = (right === undefined ? null : right);
 * }
 */
/**
 * @param {TreeNode} root
 * @return {boolean}
 */
var isValidBST = function (root) {
    return traverse(root, -Infinity, Infinity);
};

const traverse = (node, min, max) => {
    if (!node) return true;

    if (node.val <= min || node.val >= max) return false;

    return (
        traverse(node.left, min, node.val) &&
        traverse(node.right, node.val, max)
    );
};
