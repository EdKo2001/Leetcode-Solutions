class Solution {
    public int[] maximumLengthOfRanges(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] result = new int[n];

        // Monotonic stack for the left boundary
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? i : i - stack.peek() - 1;
            stack.push(i);
        }

        // Clear the stack for the right boundary
        stack.clear();

        // Monotonic stack for the right boundary
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n - i - 1 : stack.peek() - i - 1;
            stack.push(i);
        }

        for (int i = 0; i < n; i++) {
            result[i] = left[i] + right[i] + 1;
        }

        return result;
    }
}