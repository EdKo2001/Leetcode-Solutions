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
 * @return {number[]}
 */

// Recursive
var inorderTraversal = function(root) {
    const result = [];
    
    function traverse(node) {
        if(!node) return;
        
        traverse(node.left);
        result.push(node.val);
        traverse(node.right);
    }

    traverse(root);

    return result;
};

// Stack
// function inorderTraversal(root) {
//   const stack = []; 
//   const res = [];

//   while (root || stack.length) {
//     if (root) {
//       stack.push(root);
//       root = root.left;
//     } else {
//       root = stack.pop();
//       res.push(root.val);
//       root = root.right;
//     }
//   }

//   return res;
// }