class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder str = new StringBuilder();

        int word1Pointer = 0;
        int word2Pointer = 0;

        while (word1Pointer < word1.length() && word2Pointer < word2.length()) {
            str.append(word1.charAt(word1Pointer++));
            str.append(word2.charAt(word2Pointer++));
        }

        while (word1Pointer < word1.length()) {
            str.append(word1.charAt(word1Pointer++));

        }

        while (word2Pointer < word2.length()) {
            str.append(word2.charAt(word2Pointer++));
        }

        return str.toString();
    }
}