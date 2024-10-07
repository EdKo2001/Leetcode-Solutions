class Solution {
    public boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length) {
            return false;
        }

        // Step 1: Union-Find setup for transitive similarity
        UnionFind uf = new UnionFind();

        // Union all similar word pairs
        for (List<String> pair : similarPairs) {
            uf.union(pair.get(0), pair.get(1));
        }

        // Step 2: Check each word in sentence1 and sentence2
        for (int i = 0; i < sentence1.length; i++) {
            String word1 = sentence1[i];
            String word2 = sentence2[i];

            // Check if words are either the same or in the same connected component
            if (!word1.equals(word2) && !uf.isConnected(word1, word2)) {
                return false;
            }
        }

        return true;
    }

    // Union-Find / Disjoint Set implementation
    private class UnionFind {
        private Map<String, String> parent;

        public UnionFind() {
            this.parent = new HashMap<>();
        }

        // Find the root/representative of a word with path compression
        public String find(String word) {
            if (!parent.containsKey(word)) {
                parent.put(word, word); // Initialize itself as its own parent
            }
            if (!parent.get(word).equals(word)) {
                parent.put(word, find(parent.get(word))); // Path compression
            }
            return parent.get(word);
        }

        // Union two words by connecting their roots
        public void union(String word1, String word2) {
            String root1 = find(word1);
            String root2 = find(word2);
            if (!root1.equals(root2)) {
                parent.put(root1, root2); // Union by setting one root as parent of the other
            }
        }

        // Check if two words are connected (i.e., have the same root)
        public boolean isConnected(String word1, String word2) {
            return find(word1).equals(find(word2));
        }
    }
}