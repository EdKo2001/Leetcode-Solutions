class Solution {

    public int largestCombination(int[] candidates) {
        int maxCount = 0; // Variable to track the maximum count of set bits.
        for (int i = 0; i < 24; i++) {
            int count = 0; // Count of numbers with the i-th bit set.
            for (int num : candidates) {
                if ((num & (1 << i)) != 0) { // Check if the i-th bit is set.
                    count++;
                }
            }
            maxCount = Math.max(maxCount, count); // Update the maximum count.
        }
        return maxCount;
    }
}