class Solution {
    public int majorityElement(int[] nums) {
        // Boyer-Moore Voting Algorithm

        // Phase 1: Find a candidate for the majority element
        int candidate = nums[0];
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        // Phase 2: Verify that the candidate is indeed the majority element
        // (optional in this problem since it is guaranteed to exist)
        count = 0;
        for (int num : nums) {
            if (num == candidate) {
                count++;
            }
        }

        if (count > nums.length / 2) {
            return candidate;
        }

        // This should not be reached because the problem guarantees a majority element
        throw new IllegalArgumentException("No majority element found");
    }
}