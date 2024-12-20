class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int resIdx = 0;
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            int num = nums[i];

            // out of window
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // maintain desc deque
            while (!deque.isEmpty() && nums[deque.peekLast()] < num) {
                deque.pollLast();
            }

            deque.offerLast(i);

            if (i >= k - 1) {
                res[resIdx++] = nums[deque.peekFirst()];
            }
        }

        return res;
    }
}