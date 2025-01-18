/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */

/**
 * @param {TreeNode} root
 * @param {number} low
 * @param {number} high
 * @return {number}
 */
var rangeSumBST = function (root, low, high) {
    // return dfs(root, low, high);
    return bfs(root, low, high);
};

// const dfs = (node, low, high) => {
//     if (!node) return 0;

//     let sum = 0;

//     if (node.val >= low && node.val <= high) sum += node.val;

//     if (node.left) sum += dfs(node.left, low, high);
//     if (node.right) sum += dfs(node.right, low, high);

//     return sum;
// };

const bfs = (node, low, high) => {
    let sum = 0;
    const queue = [];
    queue.push(node);

    while (queue.length > 0) {
        const curr = queue.shift();
        if (curr.val >= low && curr.val <= high) sum += curr.val;
        if (curr.left) queue.push(curr.left);
        if (curr.right) queue.push(curr.right);
    }

    return sum;
}