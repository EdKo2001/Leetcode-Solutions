class Solution {

    public String longestWord(String[] words) {
        // Sort the words lexicographically
        Arrays.sort(words);

        // Set to store valid words
        Set<String> validWords = new HashSet<>();
        String longestValidWord = "";

        // Iterate through each word
        for (String currentWord : words) {
            // Check if the word is of length 1 or if its prefix exists in the set
            if (currentWord.length() == 1 ||
                    validWords.contains(
                            currentWord.substring(0, currentWord.length() - 1))) {
                // Add the current word to the set of valid words
                validWords.add(currentWord);

                // Update the longest valid word if necessary
                if (longestValidWord.length() < currentWord.length()) {
                    longestValidWord = currentWord;
                }
            }
        }

        // Return the longest valid word found
        return longestValidWord;
    }
}