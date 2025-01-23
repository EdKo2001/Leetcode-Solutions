/**
 * // Definition for a Node.
 * function _Node(val, left, right, next) {
 *    this.val = val === undefined ? null : val;
 *    this.left = left === undefined ? null : left;
 *    this.right = right === undefined ? null : right;
 *    this.next = next === undefined ? null : next;
 * };
 */

/**
 * @param {_Node} root
 * @return {_Node}
 */
var connect = function (root) {
    if (!root) return null;

    let currentLevel = root;

    while (currentLevel && currentLevel.left) {
        let node = currentLevel;

        while (node) {
            // Connect the left child to the right child
            node.left.next = node.right;

            // Connect the right child to the left child of the next node
            if (node.next) {
                node.right.next = node.next.left;
            }

            // Move to the next node in the current level
            node = node.next;
        }

        // Move down to the next level
        currentLevel = currentLevel.left;
    }

    return root;
};
