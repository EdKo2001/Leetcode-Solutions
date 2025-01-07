public class Solution {

    public List<String> stringMatching(String[] words) {
        List<String> matchingWords = new ArrayList<>();

        // Iterate through each word in the input array.
        for (
            int currentWordIndex = 0;
            currentWordIndex < words.length;
            currentWordIndex++
        ) {
            int[] lps = computeLPSArray(words[currentWordIndex]);
            // Compare the current word with all other words.
            for (
                int otherWordIndex = 0;
                otherWordIndex < words.length;
                otherWordIndex++
            ) {
                if (currentWordIndex == otherWordIndex) continue; // Skip comparing the word with itself.

                // Check if the current word is a substring of another word.
                if (
                    isSubstringOf(
                        words[currentWordIndex],
                        words[otherWordIndex],
                        lps
                    )
                ) {
                    matchingWords.add(words[currentWordIndex]); // Add it to the result list if true.
                    break; // No need to check further for this word.
                }
            }
        }

        return matchingWords;
    }

    // Function to compute the LPS (Longest Prefix Suffix) array for the substring 'sub'.
    private int[] computeLPSArray(String sub) {
        int[] lps = new int[sub.length()];
        int currentIndex = 1;
        int len = 0;

        while (currentIndex < sub.length()) {
            if (sub.charAt(currentIndex) == sub.charAt(len)) {
                len++;
                lps[currentIndex] = len;
                currentIndex++;
            } else {
                if (len > 0) {
                    len = lps[len - 1]; // Backtrack using LPS array to find a shorter match.
                } else {
                    currentIndex++;
                }
            }
        }
        return lps;
    }

    // Function to check if 'sub' is a substring of 'main' using the KMP algorithm.
    private boolean isSubstringOf(String sub, String main, int[] lps) {
        int mainIndex = 0;
        int subIndex = 0;

        while (mainIndex < main.length()) {
            if (main.charAt(mainIndex) == sub.charAt(subIndex)) {
                mainIndex++;
                subIndex++;
                if (subIndex == sub.length()) return true; // Found a match.
            } else {
                if (subIndex > 0) {
                    subIndex = lps[subIndex - 1]; // Use the LPS to skip unnecessary comparisons.
                } else {
                    mainIndex++;
                }
            }
        }
        return false; // No match found.
    }
}