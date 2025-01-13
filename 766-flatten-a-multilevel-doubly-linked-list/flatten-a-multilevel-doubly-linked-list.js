/**
 * // Definition for a _Node.
 * function _Node(val,prev,next,child) {
 *    this.val = val;
 *    this.prev = prev;
 *    this.next = next;
 *    this.child = child;
 * };
 */

/**
 * @param {_Node} head
 * @return {_Node}
 */
var flatten = function (head) {
    let curr = head;

    while (curr) {
        if (curr.child) {
            let nextNode = curr.next;

            curr.next = curr.child;
            curr.child.prev = curr;

            curr.child = null;

            let lastChild = curr.next;
            while (lastChild.next) {
                lastChild = lastChild.next;
            }

            lastChild.next = nextNode;
            if (nextNode) nextNode.prev = lastChild;
        }

        curr = curr.next;
    }

    return head;
};