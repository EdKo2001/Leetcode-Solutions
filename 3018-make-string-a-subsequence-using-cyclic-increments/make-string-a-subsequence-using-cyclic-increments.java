class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int i = 0, j = 0;

        while (i < str1.length() && j < str2.length()) {
            int diff = (str2.charAt(j) - str1.charAt(i) + 26) % 26;

            if (diff <= 1) {
                j++;
            }

            i++;
        }

        return j == str2.length();
    }
}