class Solution {
    public String compressedString(String word) {
        StringBuilder str = new StringBuilder();
        int localCount = 1;

        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) != word.charAt(i - 1) || localCount == 9) {
                str.append(localCount).append(word.charAt(i - 1));
                localCount = 1;
            } else {
                localCount++;
            }
        }

        str.append(localCount).append(word.charAt(word.length() - 1));

        return str.toString();
    }
}
