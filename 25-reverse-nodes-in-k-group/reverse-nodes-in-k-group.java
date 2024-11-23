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

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupEnd = dummy;

        while (true) {
            // Check if there are at least k nodes left to reverse
            ListNode kthNode = prevGroupEnd;
            for (int i = 0; i < k && kthNode != null; i++) {
                kthNode = kthNode.next;
            }
            if (kthNode == null)
                break; // Not enough nodes to reverse, exit loop

            // Reverse k nodes
            ListNode groupStart = prevGroupEnd.next;
            ListNode prev = kthNode.next;
            ListNode current = groupStart;

            for (int i = 0; i < k; i++) {
                ListNode nextTemp = current.next;
                current.next = prev;
                prev = current;
                current = nextTemp;
            }

            // Connect the reversed group to the rest of the list
            prevGroupEnd.next = prev; // prev is now the first node of the reversed group
            prevGroupEnd = groupStart; // Move to the end of the current group
        }

        return dummy.next;
    }
}