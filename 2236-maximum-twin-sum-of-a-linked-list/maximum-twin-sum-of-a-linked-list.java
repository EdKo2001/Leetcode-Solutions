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
    public int pairSum(ListNode head) {
        // Solution 1
        // List<Integer> values = new ArrayList<>();
        // ListNode current = head;

        // while (current != null) {
        // values.add(current.val);
        // current = current.next;
        // }

        // int maxSum = 0;
        // int left = 0;
        // int right = values.size() - 1;

        // while (left < right) {
        // int twinSum = values.get(left) + values.get(right);
        // maxSum = Math.max(maxSum, twinSum);
        // left++;
        // right--;
        // }

        // return maxSum;

        // Solution2
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null;
        while (slow != null) {
            ListNode tempNext = slow.next;
            slow.next = prev;
            prev = slow;
            slow = tempNext;
        }

        int maxTwinSum = Integer.MIN_VALUE;

        while (prev != null) {
            maxTwinSum = Math.max(maxTwinSum, prev.val + head.val);
            prev = prev.next;
            head = head.next;
        }

        return maxTwinSum;
    }
}