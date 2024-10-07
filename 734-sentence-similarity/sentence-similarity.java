class Solution {
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        // Step 1: Check if both sentences have the same length
        if (sentence1.length != sentence2.length) {
            return false;
        }

        // Step 2: Create a set to store the similar pairs for fast lookup
        Set<String> similaritySet = new HashSet<>();
        for (List<String> pair : similarPairs) {
            // Add both directions (word1, word2) and (word2, word1) for bidirectional
            // similarity
            similaritySet.add(pair.get(0) + "," + pair.get(1));
            similaritySet.add(pair.get(1) + "," + pair.get(0));
        }

        // Step 3: Iterate through the words in both sentences
        for (int i = 0; i < sentence1.length; i++) {
            String word1 = sentence1[i];
            String word2 = sentence2[i];

            // If the words are not the same and are not in the similarity set, return false
            if (!word1.equals(word2) && !similaritySet.contains(word1 + "," + word2)) {
                return false;
            }
        }

        // If all words pass the similarity check, return true
        return true;
    }
}