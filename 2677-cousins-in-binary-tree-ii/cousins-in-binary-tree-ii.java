class Solution {

    public TreeNode replaceValueInTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        int previousLevelSum = root.val;

        while (!nodeQueue.isEmpty()) {
            int levelSize = nodeQueue.size();
            Queue<TreeNode> currentLevelNodes = new LinkedList<>();
            int currentLevelSum = 0;

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = nodeQueue.poll();
                // Update node value to cousin sum
                currentNode.val = previousLevelSum - currentNode.val;

                // Calculate sibling sum
                int siblingSum = (currentNode.left != null ? currentNode.left.val : 0) +
                        (currentNode.right != null ? currentNode.right.val : 0);

                if (currentNode.left != null) {
                    currentLevelSum += currentNode.left.val; // Accumulate current level sum
                    currentNode.left.val = siblingSum; // Update left child's value
                    nodeQueue.offer(currentNode.left); // Add to queue for next level
                }
                if (currentNode.right != null) {
                    currentLevelSum += currentNode.right.val; // Accumulate current level sum
                    currentNode.right.val = siblingSum; // Update right child's value
                    nodeQueue.offer(currentNode.right); // Add to queue for next level
                }
            }

            previousLevelSum = currentLevelSum; // Update previous level sum for next iteration
        }
        return root;
    }
}