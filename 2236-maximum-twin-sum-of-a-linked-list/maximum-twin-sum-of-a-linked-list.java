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
        List<Integer> values = new ArrayList<>();
        ListNode current = head;

        while (current != null) {
            values.add(current.val);
            current = current.next;
        }

        int maxSum = 0;
        int left = 0;
        int right = values.size() - 1;

        while (left < right) {
            int twinSum = values.get(left) + values.get(right);
            maxSum = Math.max(maxSum, twinSum);
            left++;
            right--;
        }

        return maxSum;
    }
}