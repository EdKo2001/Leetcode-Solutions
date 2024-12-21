class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1;
        int right = nums[0];
        int minDivisor = -1;

        for (int num : nums) {
            right = Math.max(right, num);
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int divisionsSum = divisionsSum(nums, mid);

            if (divisionsSum <= threshold) {
                minDivisor = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return minDivisor;
    }

    private int divisionsSum(int[] nums, int divisor) {
        int sum = 0;
        for (int num : nums) {
            sum += Math.ceil((1.0 * num) / divisor);
        }
        return sum;
    }
}
