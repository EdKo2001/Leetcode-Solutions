import java.util.HashMap;

class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> baskets = new HashMap<>();
        int left = 0; // Start of the sliding window
        int maxFruits = 0;

        for (int right = 0; right < fruits.length; right++) {
            // Add the current fruit to the basket
            baskets.put(fruits[right], baskets.getOrDefault(fruits[right], 0) + 1);

            // If there are more than two types of fruits, shrink the window
            while (baskets.size() > 2) {
                int leftFruit = fruits[left];
                baskets.put(leftFruit, baskets.get(leftFruit) - 1);

                // Remove the fruit if its count reaches 0
                if (baskets.get(leftFruit) == 0) {
                    baskets.remove(leftFruit);
                }
                left++; // Move the window's left side forward
            }

            // Calculate the maximum number of fruits in the current window
            maxFruits = Math.max(maxFruits, right - left + 1);
        }

        return maxFruits;
    }
}
