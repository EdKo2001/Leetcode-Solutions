class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] results = new int[n - k + 1];

        for (int i = 0; i < n - k + 1; i++) {
            boolean isConsecutiveAndSorted = true;
            for (int j = i; j < i + k - 1; j++) {
                if (nums[j + 1] - nums[j] != 1) {
                    isConsecutiveAndSorted = false;
                    break;
                }
            }

            results[i] = isConsecutiveAndSorted ? nums[i + k - 1] : -1;
        }

        return results;
    }
}