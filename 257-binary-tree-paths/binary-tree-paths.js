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
var binaryTreePaths = function(root) {
    const result = [];
    
    // Helper function for backtracking
    const backtrack = (node, path) => {
        if (!node) return; // Base case: if the node is null, stop further processing
        
        // Add the current node's value to the path
        path.push(node.val);
        
        // If it's a leaf node, add the path to the result
        if (!node.left && !node.right) {
            result.push(path.join("->"));
        } else {
            // Recursively explore left and right subtrees
            backtrack(node.left, path);
            backtrack(node.right, path);
        }
        
        // Backtrack: remove the current node's value from the path
        path.pop();
    };
    
    backtrack(root, []);
    return result;
};
