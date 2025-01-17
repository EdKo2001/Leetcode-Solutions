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
 * @return {string[]}
 */
var binaryTreePaths = function (root) {
    const res = [];

    const backtracking = (node, arr) => {
        if (!node.left && !node.right) {
            arr.push(node.val);
            res.push(arr.join("->"));
        } else {
            node.left && backtracking(node.left, [...arr, node.val]);
            node.right && backtracking(node.right, [...arr, node.val]);
        }
    }

    backtracking(root, []);
    return res;
};