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
    // Explicit lvl counting
    // public long kthLargestLevelSum(TreeNode root, int k) {
    //     if (root == null)
    //         return -1;

    //     PriorityQueue<Long> minHeap = new PriorityQueue<>();
    //     long curSum = 0;

    //     Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
    //     queue.offer(new Pair<>(root, 0));

    //     int curLvl = 0;
    //     while (!queue.isEmpty()) {
    //         Pair<TreeNode, Integer> current = queue.poll();
    //         TreeNode currentNode = current.getKey();
    //         int level = current.getValue();

    //         if (level > curLvl) {
    //             if (minHeap.size() < k || minHeap.peek() < curSum) {
    //                 minHeap.offer(curSum);
    //                 if (minHeap.size() > k) {
    //                     minHeap.poll();
    //                 }
    //             }
    //             curSum = 0;
    //             curLvl = level;
    //         }

    //         curSum += currentNode.val;

    //         if (currentNode.left != null)
    //             queue.offer(new Pair<>(currentNode.left, level + 1));

    //         if (currentNode.right != null)
    //             queue.offer(new Pair<>(currentNode.right, level + 1));
    //     }

    //     // Add the sum of the last level
    //     if (minHeap.size() < k || minHeap.peek() < curSum) {
    //         minHeap.offer(curSum);
    //         if (minHeap.size() > k) {
    //             minHeap.poll();
    //         }
    //     }

    //     // If we don't have k levels, return 0 or handle appropriately
    //     return minHeap.size() == k ? minHeap.peek() : -1;
    // }

    public long kthLargestLevelSum(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }

        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size(); // Get the number of nodes at the current level
            long curSum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                curSum += currentNode.val; // Accumulate the sum of the current level

                // Add child nodes for the next level
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

            // Add the current level's sum to the min-heap
            if (minHeap.size() < k) {
                minHeap.offer(curSum);
            } else if (curSum > minHeap.peek()) {
                minHeap.poll(); // Remove the smallest sum
                minHeap.offer(curSum); // Add the new level sum
            }
        }

        // If there are fewer than k levels, return -1
        return minHeap.size() == k ? minHeap.peek() : -1;
    }
}
