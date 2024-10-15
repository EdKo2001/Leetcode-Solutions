class Solution {
    TreeNode curr;

    public TreeNode increasingBST(TreeNode root) {
        TreeNode newTree = new TreeNode(0);
        curr = newTree;

        bst(root);

        return newTree.right;
    }

    public void bst(TreeNode root) {
        if (root == null)
            return;

        bst(root.left);

        curr.right = new TreeNode(root.val);
        curr = curr.right;

        bst(root.right);
    }
}
