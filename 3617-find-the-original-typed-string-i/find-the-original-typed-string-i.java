class Solution {
    public int possibleStringCount(String word) {
        if (word == null || word.isEmpty()) {
            return 0;
        }

        int cnt = 1;
        char prev = word.charAt(0);

        for (int i = 1; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch == prev) {
                cnt++;
            } else {
                prev = ch;
            }
        }

        return cnt;
    }
}
