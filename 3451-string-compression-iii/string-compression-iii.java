class Solution {
    public String compressedString(String word) {
        StringBuilder str = new StringBuilder();

        int localCount = 1;
        int lastChar = 0;
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i - 1) != word.charAt(i)) {
                if (localCount > 0) {
                    str.append(localCount).append(word.charAt(i - 1));
                }
                localCount = 1;
                lastChar = i;
            } else {
                localCount++;
                if (localCount == 9) {
                    str.append(localCount).append(word.charAt(i));
                    localCount = 0;
                }
            }
        }

        if (localCount > 0) {
            str.append(localCount).append(word.charAt(lastChar));
        }

        return str.toString();
    }
}