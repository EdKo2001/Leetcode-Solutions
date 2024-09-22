class Solution {
    public boolean isBalanced(TreeNode root) {
        return dfs(root) != -1;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0; // base case: height is 0 for null node
        
        int leftHeight = dfs(node.left);
        if (leftHeight == -1) return -1; // early return if left subtree is unbalanced
        
        int rightHeight = dfs(node.right);
        if (rightHeight == -1) return -1; // early return if right subtree is unbalanced
        
        if (Math.abs(leftHeight - rightHeight) > 1) return -1; // current node is unbalanced

        return 1 + Math.max(leftHeight, rightHeight); // return height of the current subtree
    }
}
