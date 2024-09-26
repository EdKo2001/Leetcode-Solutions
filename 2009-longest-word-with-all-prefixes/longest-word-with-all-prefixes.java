class Solution {

    public String longestWord(String[] words) {
        Trie trie = new Trie();
        String longestValidWord = "";

        // Insert all words into the trie
        for (String word : words) {
            trie.insert(word);
        }

        // Check each word and update the longest valid word
        for (String word : words) {
            if (trie.hasAllPrefixes(word)) {
                if (word.length() > longestValidWord.length() ||
                        (word.length() == longestValidWord.length() &&
                                word.compareTo(longestValidWord) < 0)) {
                    longestValidWord = word;
                }
            }
        }

        return longestValidWord;
    }

    private static class Trie {

        private static class TrieNode {

            TrieNode[] children = new TrieNode[26];
            boolean isEndOfWord;
        }

        private final TrieNode root = new TrieNode();

        // Insert a word into the trie
        public void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.isEndOfWord = true;
        }

        // Check if all prefixes of the word exist in the trie
        public boolean hasAllPrefixes(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                node = node.children[c - 'a'];
                if (node == null || !node.isEndOfWord) {
                    return false;
                }
            }
            return true;
        }
    }
}