/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val === undefined ? 0 : val);
 *     this.left = (left === undefined ? null : left);
 *     this.right = (right === undefined ? null : right);
 * }
 */
/**
 * @param {TreeNode} root
 * @param {number} x
 * @param {number} y
 * @return {boolean}
 */
var isCousins = function (root, x, y) {
    return bfs(root, x, y);
};

const bfs = (root, x, y) => {
    const queue = [{ node: root, parent: null }];

    while (queue.length > 0) {
        const lvlLength = queue.length;
        let xParent = null;
        let yParent = null;

        for (let i = 0; i < lvlLength; i++) {
            const { node, parent } = queue.shift();

            if (node.val === x) xParent = parent;
            if (node.val === y) yParent = parent;

            if (xParent && yParent) return xParent !== yParent;

            if (node.left) queue.push({ node: node.left, parent: node });
            if (node.right) queue.push({ node: node.right, parent: node });
        }


        if ((xParent && !yParent) || (!xParent && yParent)) return false;
    }

    return false;
};
