/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {number[]} preorder
 * @param {number[]} postorder
 * @return {TreeNode}
 */
var constructFromPrePost = function(preorder, postorder) {
    let preIndex = 0, postIndex = 0;

    function construct() {
        let root = new TreeNode(preorder[preIndex++]); // Root from preorder
        
        if (root.val !== postorder[postIndex]) { // Left subtree exists
            root.left = construct();
        }
        
        if (root.val !== postorder[postIndex]) { // Right subtree exists
            root.right = construct();
        }

        postIndex++; // Move postorder index since we finished this root
        return root;
    }

    return construct();
};
