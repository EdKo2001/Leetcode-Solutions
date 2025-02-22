/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */

/**
 * @param {string} traversal
 * @return {TreeNode}
 */
var recoverFromPreorder = function (traversal) {
    let i = 0;
    const stack = [];

    while (i < traversal.length) {
        // Step 1: Count the depth (number of '-')
        let depth = 0;
        while (i < traversal.length && traversal[i] === "-") {
            depth++;
            i++;
        }

        // Step 2: Extract the full number
        let num = 0;
        while (i < traversal.length && traversal[i] !== "-") {
            num = num * 10 + (traversal[i].charCodeAt(0) - 48); // Convert char to number
            i++;
        }

        // Step 3: Create the node
        let node = new TreeNode(num);

        // Step 4: Attach to parent at depth - 1
        if (depth === 0) {
            stack[depth] = node; // Root node
        } else {
            let parent = stack[depth - 1]; // Parent node at depth - 1
            if (!parent.left) parent.left = node;
            else parent.right = node;
            stack[depth] = node; // Update stack for this depth
        }
    }

    return stack[0]; // The root node
};
