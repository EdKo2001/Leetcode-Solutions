class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        return dfs(root, low, high);
    }

    public TreeNode dfs(TreeNode node, int low, int high) {
        if (node == null)
            return null;

        // If the current node's value is less than low, trim the left subtree and explore the right
        if (node.val < low) {
            return dfs(node.right, low, high);
        }

        // If the current node's value is greater than high, trim the right subtree and explore the left
        if (node.val > high) {
            return dfs(node.left, low, high);
        }

        // Otherwise, recursively trim both subtrees
        node.left = dfs(node.left, low, high);
        node.right = dfs(node.right, low, high);

        return node;
    }
}
