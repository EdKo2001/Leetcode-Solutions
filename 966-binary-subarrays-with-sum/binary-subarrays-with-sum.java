class Solution {
    // public int numSubarraysWithSum(int[] nums, int goal) {
    //     return atMost(nums, goal) - atMost(nums, goal - 1);
    // }

    // private int atMost(int[] nums, int goal) {
    //     if (goal < 0)
    //         return 0; // If the goal is negative, no subarrays are valid.

    //     int start = 0, count = 0, currSum = 0;

    //     for (int end = 0; end < nums.length; end++) {
    //         currSum += nums[end];

    //         while (currSum > goal) {
    //             currSum -= nums[start++];
    //         }

    //         count += end - start + 1;
    //     }

    //     return count;
    // }

    public int numSubarraysWithSum(int[] nums, int goal) {
        int start = 0;
        int prefixZeros = 0;
        int currentSum = 0;
        int totalCount = 0;

        for (int end = 0; end < nums.length; end++) {
            currentSum += nums[end];

            while (start < end && (nums[start] == 0 || currentSum > goal)) {
                if (nums[start] == 1) {
                    prefixZeros = 0;
                } else {
                    prefixZeros++;
                }

                currentSum -= nums[start];
                start++;
            }

            if (currentSum == goal) {
                totalCount += 1 + prefixZeros;
            }
        }

        return totalCount;
    }
}