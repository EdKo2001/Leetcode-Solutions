/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        // If root is null, return null
        if (root == null) return null;

        // Find the node to delete
        if (key < root.val) {
            root.left = deleteNode(root.left, key); // search in left subtree
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key); // search in right subtree
        } else {
            // Node found, handle three cases:
            
            // 1. Node has no children (leaf node)
            if (root.left == null && root.right == null) {
                return null;
            }
            
            // 2. Node has only one child
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            
            // 3. Node has two children:
            // Find the minimum node in the right subtree (inorder successor)
            TreeNode minNode = findMin(root.right);
            
            // Replace current node's value with the minimum node's value
            root.val = minNode.val;
            
            // Delete the minimum node in the right subtree
            root.right = deleteNode(root.right, minNode.val);
        }
        
        return root;
    }
    
    // Helper method to find the minimum node in a tree (leftmost node)
    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
