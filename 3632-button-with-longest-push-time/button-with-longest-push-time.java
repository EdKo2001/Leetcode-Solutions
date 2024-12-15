class Solution {
    public int buttonWithLongestTime(int[][] events) {
        int longestTime = events[0][1];
        int longestIdx = events[0][0];
        int prevTime = events[0][1];

        for (int i = 1; i < events.length; i++) {
            int currentTime = events[i][1];
            int timeDifference = currentTime - prevTime;

            // Update the longest time and button index if a longer time is found
            // or if the same time is found but the current button index is smaller
            if (timeDifference > longestTime || (timeDifference == longestTime && events[i][0] < longestIdx)) {
                longestTime = timeDifference;
                longestIdx = events[i][0];
            }

            prevTime = currentTime;
        }

        return longestIdx;
    }
}
