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
    public long kthLargestLevelSum(TreeNode root, int k) {
        if (root == null)
            return -1;

        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        long curSum = 0;

        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, 0));

        int curLvl = 0;
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> current = queue.poll();
            TreeNode currentNode = current.getKey();
            int level = current.getValue();

            if (level > curLvl) {
                if (minHeap.size() < k || minHeap.peek() < curSum) {
                    minHeap.offer(curSum);
                    if (minHeap.size() > k) {
                        minHeap.poll();
                    }
                }
                curSum = 0;
                curLvl = level;
            }

            curSum += currentNode.val;

            if (currentNode.left != null)
                queue.offer(new Pair<>(currentNode.left, level + 1));

            if (currentNode.right != null)
                queue.offer(new Pair<>(currentNode.right, level + 1));
        }

        // Add the sum of the last level
        if (minHeap.size() < k || minHeap.peek() < curSum) {
            minHeap.offer(curSum);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // If we don't have k levels, return 0 or handle appropriately
        return minHeap.size() == k ? minHeap.peek() : -1;
    }
}
