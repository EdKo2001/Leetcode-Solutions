class Solution {

    boolean nodesFound = false;

    public TreeNode lowestCommonAncestor(
        TreeNode root,
        TreeNode p,
        TreeNode q
    ) {
        // Start DFS traversal to find the lowest common ancestor
        TreeNode ans = dfs(root, p, q);
        // Return the result only if both nodes are found
        return nodesFound ? ans : null;
    }

    private TreeNode dfs(TreeNode node, TreeNode p, TreeNode q) {
        // Base case: If the node is null, return null
        if (node == null) return null;

        // Recursively search the left and right subtrees
        TreeNode left = dfs(node.left, p, q);
        TreeNode right = dfs(node.right, p, q);

        // Check conditions for current node being part of the solution
        int conditions = 0;
        if (node == p || node == q) conditions++;
        if (left != null) conditions++;
        if (right != null) conditions++;
        if (conditions == 2) nodesFound = true; // Mark that both nodes are found

        // Determine if current node is the lowest common ancestor
        if (
            (left != null && right != null) || node == p || node == q
        ) return node;

        // Return the non-null child, if any
        return left != null ? left : right;
    }
}