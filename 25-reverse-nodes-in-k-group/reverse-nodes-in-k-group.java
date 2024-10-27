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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1)
            return head;

        // Check if there are at least k nodes left in the list
        ListNode node = head;
        int count = 0;
        while (node != null && count < k) {
            node = node.next;
            count++;
        }

        // If there are k nodes, proceed with reversal
        if (count == k) {
            ListNode cur = head;
            ListNode prev = null;
            ListNode next = null;

            // Reverse k nodes
            for (int i = 0; i < k; i++) {
                next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }

            // Recursively call reverseKGroup on the remaining nodes
            head.next = reverseKGroup(next, k);

            // Return the new head of the reversed group
            return prev;
        }

        // If less than k nodes remain, return the head as-is
        return head;
    }
}
