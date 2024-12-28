class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int ans = Integer.MIN_VALUE;
        int start = 0;
        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();
        for (int end = 0; end < nums.length; end++) {
            // Add the current number to the maxDeque
            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] < nums[end]) {
                maxDeque.pollLast();
            }
            maxDeque.addLast(end);

            // Add the current number to the minDeque
            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] > nums[end]) {
                minDeque.pollLast();
            }
            minDeque.addLast(end);

            // Check if the difference between max and min exceeds the limit
            while (!maxDeque.isEmpty() && !minDeque.isEmpty() &&
                    nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > limit) {
                // Move the start pointer to shrink the window
                if (maxDeque.peekFirst() == start)
                    maxDeque.pollFirst();
                if (minDeque.peekFirst() == start)
                    minDeque.pollFirst();
                start++;
            }

            ans = Math.max(ans, end - start + 1);
        }
        return ans;
    }
}