class Solution {
    HashMap<Integer, Integer> memo = new HashMap<>();

    public int numDecodings(String s) {
        return recursiveMemo(0, s);
    }

    private int recursiveMemo(int index, String s) {
        // If the end of the string is reached, one valid decoding is found
        if (index == s.length()) {
            return 1;
        }

        // If the character at the current index is '0', it cannot be decoded
        if (s.charAt(index) == '0') {
            return 0;
        }

        // Check if this result is already computed
        if (memo.containsKey(index)) {
            return memo.get(index);
        }

        // Decode the single character
        int ways = recursiveMemo(index + 1, s);

        // Decode the two-character substring (if it’s within bounds and valid)
        if (index + 1 < s.length()) {
            int twoDigit = Integer.parseInt(s.substring(index, index + 2));
            if (twoDigit >= 10 && twoDigit <= 26) {
                ways += recursiveMemo(index + 2, s);
            }
        }

        // Store the result in the memoization map
        memo.put(index, ways);

        return ways;
    }
}
