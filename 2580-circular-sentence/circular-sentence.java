class Solution {
    public boolean isCircularSentence(String sentence) {
        char start = ' ';
        char prev = ' ';

        for (int i = 0; i < sentence.length(); i++) {
            if (i == 0)
                start = sentence.charAt(i);
            if (i > 0 && sentence.charAt(i - 1) == ' ' && sentence.charAt(i) != prev)
                return false;
            if (i < sentence.length() - 1 && sentence.charAt(i + 1) == ' ')
                prev = sentence.charAt(i);
            if (i == sentence.length() - 1)
                return start == sentence.charAt(i);
        }

        return true;
    }
}