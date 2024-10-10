public class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        // Step 1: Create a decreasing stack of indices
        Stack<Integer> stack = new Stack<>();
        
        // Populate the stack with indices where nums is in decreasing order
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty() || nums[stack.peek()] > nums[i]) {
                stack.push(i);
            }
        }
        
        int maxWidth = 0;
        
        // Step 2: Traverse the array from the end to the start
        for (int j = n - 1; j >= 0; j--) {
            // While the top of the stack is a valid ramp, update maxWidth
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[j]) {
                maxWidth = Math.max(maxWidth, j - stack.pop());
            }
        }
        
        return maxWidth;
    }
}
