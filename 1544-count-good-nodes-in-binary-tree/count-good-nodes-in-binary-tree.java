/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    int cnt = 0;

    public int goodNodes(TreeNode root) {
        if (root == null)
            return 0;

        bfs(root, root.val);

        return cnt;
    }

    public void bfs(TreeNode node, int x) {
        if (node == null)
            return;

        if (node.val >= x)
            cnt++;

        bfs(node.left, Math.max(x, node.val));
        bfs(node.right, Math.max(x, node.val));
    }
}