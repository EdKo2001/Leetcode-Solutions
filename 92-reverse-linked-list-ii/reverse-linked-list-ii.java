/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right)
            return head;

        // Create a dummy node to handle edge cases like left == 1
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // Step 1: Traverse to the node just before the 'left' position
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // The `prev` node is now just before the sublist to reverse
        ListNode sublistHead = prev.next;
        ListNode curr = sublistHead;

        // Step 2: Reverse the sublist
        ListNode tmp = null;
        for (int i = left; i <= right; i++) {
            ListNode nextNode = curr.next;
            curr.next = tmp;
            tmp = curr;
            curr = nextNode;
        }

        // Step 3: Reconnect the reversed sublist to the rest of the list
        prev.next = tmp; // Connect the node before 'left' to the new head of the reversed sublist
        sublistHead.next = curr; // Connect the tail of the reversed sublist to the node after 'right'

        return dummy.next; // Return the original head (or new head if left == 1)
    }
}
