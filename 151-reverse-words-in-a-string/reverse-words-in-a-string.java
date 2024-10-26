class Solution {
    public String reverseWords(String s) {
        List<String> wordsReversedOrder = new ArrayList<>();

        int start = s.length();
        int end = s.length() - 1;

        while (end >= 0) {
            if (s.charAt(end) == ' ') {
                if (end + 1 < start) { // Avoid adding empty strings
                    wordsReversedOrder.add(s.substring(end + 1, start));
                }
                start = end;
            }
            end--;
        }

        // Add the last word if it exists
        if (end + 1 < start) {
            wordsReversedOrder.add(s.substring(end + 1, start));
        }

        return String.join(" ", wordsReversedOrder);
    }
}
