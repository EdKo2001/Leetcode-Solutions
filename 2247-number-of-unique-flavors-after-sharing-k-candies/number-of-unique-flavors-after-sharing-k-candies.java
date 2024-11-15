import java.util.HashMap;
import java.util.Map;

class Solution {

    public int shareCandies(int[] candies, int k) {
        int uniqueFlav = 0;

        // Store the total number of unique flavors in the array.
        Map<Integer, Integer> flavFreq = new HashMap<>();
        for (int c : candies) {
            flavFreq.put(c, flavFreq.getOrDefault(c, 0) + 1);
            if (flavFreq.get(c) == 1) {
                uniqueFlav++;
            }
        }

        // Get the flavors used completely in the window.
        int usedInWindow = 0;
        for (int i = 0; i < k; i++) {
            flavFreq.put(candies[i], flavFreq.get(candies[i]) - 1);
            if (flavFreq.get(candies[i]) == 0) {
                usedInWindow++;
            }
        }

        // Get the flavors in the remaining array currently.
        int maxFlav = uniqueFlav - usedInWindow;

        // Slide the window to the right.
        for (int i = k; i < candies.length; i++) {
            // Remove the candy on the left end from the window.
            flavFreq.put(candies[i - k], flavFreq.get(candies[i - k]) + 1);
            if (flavFreq.get(candies[i - k]) == 1) {
                usedInWindow--;
            }

            // Add the candy on the right end at index i.
            flavFreq.put(candies[i], flavFreq.get(candies[i]) - 1);
            if (flavFreq.get(candies[i]) == 0) {
                usedInWindow++;
            }

            maxFlav = Math.max(maxFlav, uniqueFlav - usedInWindow);
        }

        return maxFlav;
    }
}