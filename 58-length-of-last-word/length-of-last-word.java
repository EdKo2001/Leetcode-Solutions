class Solution {
    public int lengthOfLastWord(String s) {
        int length = 0;
        boolean foundChar = false;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (foundChar && s.charAt(i) == ' ') {
                return length;
            }
            if (s.charAt(i) != ' ') {
                foundChar = true;
                length++;
            }
        }
        return length;
    }
}