class TrieNode {

    // Each node has up to 10 possible children (digits 0-9)
    TrieNode[] children = new TrieNode[10];
}

class Trie {

    TrieNode root = new TrieNode();

    // Insert a number into the Trie by treating it as a string of digits
    void insert(int num) {
        TrieNode node = root;
        String numStr = Integer.toString(num);
        for (char digit : numStr.toCharArray()) {
            int idx = digit - '0';
            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();
            }
            node = node.children[idx];
        }
    }

    // Find the longest common prefix for a number in arr2 with the Trie
    int findLongestPrefix(int num) {
        TrieNode node = root;
        String numStr = Integer.toString(num);
        int len = 0;

        for (char digit : numStr.toCharArray()) {
            int idx = digit - '0';
            if (node.children[idx] != null) {
                // Increase length if the current digit matches
                len++;
                node = node.children[idx];
            } else {
                // Stop if no match for the current digit
                break;
            }
        }
        return len;
    }
}

class Solution {

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Trie trie = new Trie();

        // Step 1: Insert all numbers from arr1 into the Trie
        for (int num : arr1) {
            trie.insert(num);
        }

        int longestPrefix = 0;

        // Step 2: Find the longest prefix match for each number in arr2
        for (int num : arr2) {
            int len = trie.findLongestPrefix(num);
            longestPrefix = Math.max(longestPrefix, len);
        }

        return longestPrefix;
    }
}