class Solution {
    public void reverseString(char[] s) {
        int n = s.length;
        for (int i = 0; i < s.length / 2; i++) {
            char tmp = s[i];
            s[i] = s[n - i - 1];
            s[n - i - 1] = tmp;
        }
    }
}