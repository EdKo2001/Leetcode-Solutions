class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1; // Minimum possible penalty
        int right = 0; // Maximum penalty is the largest bag size
        for (int num : nums) {
            right = Math.max(right, num);
        }

        int result = right; // Store the minimum penalty

        while (left <= right) {
            int mid = left + (right - left) / 2; // Midpoint penalty candidate

            if (canAchievePenalty(nums, maxOperations, mid)) {
                result = mid; // Update the result, try a smaller penalty
                right = mid - 1;
            } else {
                left = mid + 1; // Try a larger penalty
            }
        }

        return result;
    }

    // Helper function to check if a given penalty can be achieved
    private boolean canAchievePenalty(int[] nums, int maxOperations, int penalty) {
        int operations = 0;

        for (int num : nums) {
            if (num > penalty) {
                operations += (num - 1) / penalty; // Calculate operations needed
            }
        }

        return operations <= maxOperations;
    }
}