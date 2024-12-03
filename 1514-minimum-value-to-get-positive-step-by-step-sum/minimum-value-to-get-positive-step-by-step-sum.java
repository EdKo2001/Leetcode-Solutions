class Solution {
    public int minStartValue(int[] nums) {
        // Store the minimum prefix sum
        int minValue = 0;

        // Stores prefix sum at each index
        int sum = 0;

        // Traverse over the array
        for (int n : nums) {

            // Update the prefix sum
            sum += n;

            // Update the minValue
            minValue = Math.min(minValue, sum);
        }

        int startValue = 1 - minValue;

        // Return the positive start value
        return startValue;
    }
}