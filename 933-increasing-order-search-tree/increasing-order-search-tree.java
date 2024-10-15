class Solution {
    TreeNode curr;

    public TreeNode increasingBST(TreeNode root) {
        TreeNode newTree = new TreeNode(0);
        curr = newTree;

        inorder(root);

        return newTree.right;
    }

    public void inorder(TreeNode root) {
        if (root == null)
            return;

        inorder(root.left);

        curr.right = new TreeNode(root.val);
        curr = curr.right;

        inorder(root.right);
    }
}
