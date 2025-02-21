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
 */
var FindElements = function (root) {
    this.valuesSet = new Set();
    root.val = 0;
    const dfs = (node) => {
        this.valuesSet.add(node.val);
        if (node.left) {
            node.left.val = node.val * 2 + 1;
            dfs(node.left);
        }
        if (node.right) {
            node.right.val = node.val * 2 + 2;
            dfs(node.right);
        }
    }

    dfs(root);
};

/** 
 * @param {number} target
 * @return {boolean}
 */
FindElements.prototype.find = function (target) {
    return this.valuesSet.has(target);
};

/** 
 * Your FindElements object will be instantiated and called as such:
 * var obj = new FindElements(root)
 * var param_1 = obj.find(target)
 */