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
    public TreeNode reverseOddLevels(TreeNode root) {
        dfs(root.left, root.right, 1);
        // bfs(root);
        return root;
    }

    private void dfs(TreeNode left, TreeNode right, int depth) {
        if (left == null || right == null)
            return;

        // Swap values at odd levels
        if (depth % 2 == 1) {
            int temp = left.val;
            left.val = right.val;
            right.val = temp;
        }

        // Recurse for children
        dfs(left.left, right.right, depth + 1);
        dfs(left.right, right.left, depth + 1);
    }

    // private void bfs(TreeNode root) {
    //     Queue<TreeNode> queue = new LinkedList<>();
    //     queue.offer(root);

    //     int depth = 0;
    //     while (!queue.isEmpty()) {
    //         int size = queue.size();
    //         List<TreeNode> currentLevel = new ArrayList<>();

    //         // Collect nodes of the current level
    //         for (int i = 0; i < size; i++) {
    //             TreeNode node = queue.poll();
    //             currentLevel.add(node);

    //             if (node.left != null)
    //                 queue.offer(node.left);
    //             if (node.right != null)
    //                 queue.offer(node.right);
    //         }

    //         // Reverse values if at an odd level
    //         if (depth % 2 == 1) {
    //             int left = 0, right = currentLevel.size() - 1;
    //             while (left < right) {
    //                 int temp = currentLevel.get(left).val;
    //                 currentLevel.get(left).val = currentLevel.get(right).val;
    //                 currentLevel.get(right).val = temp;
    //                 left++;
    //                 right--;
    //             }
    //         }

    //         depth++;
    //     }
    // }
}