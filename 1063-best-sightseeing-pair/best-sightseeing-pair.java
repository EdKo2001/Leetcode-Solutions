class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        int maxScore = 0;
        int max_i_value = values[0] - 0;

        for (int j = 1; j < n; j++) {
            maxScore = Math.max(maxScore, max_i_value + values[j] - j);
            max_i_value = Math.max(max_i_value, values[j] + j);
        }

        return maxScore;
    }
}