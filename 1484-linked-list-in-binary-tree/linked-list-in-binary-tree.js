/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {ListNode} head
 * @param {TreeNode} root
 * @return {boolean}
 */
var isSubPath = function (head, root) {
    if (!root) return false;

    // Check if the current tree node matches the list or check its children
    return dfs(root, head) || isSubPath(head, root.left) || isSubPath(head, root.right);
};

const dfs = (node, list) => {
    if (!list) return true;
    if (!node) return false;


    if (node.val === list.val) {
        return dfs(node.left, list.next) || dfs(node.right, list.next);
    }

    return false;
};
