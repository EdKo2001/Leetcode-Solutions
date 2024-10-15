class Solution {

    public long minimumSteps(String s) {
        long totalSwaps = 0;
        int blackBallCount = 0;

        // Iterate through each ball (character) in the string
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                // Swap with all black balls to its left
                totalSwaps += (long) blackBallCount;
            } else {
                // Increment the count
                blackBallCount++;
            }
        }

        return totalSwaps;
    }
}