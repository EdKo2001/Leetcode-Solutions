class Solution {
    // Top-down (Memoization)
    // HashMap<Integer, Integer> memo = new HashMap<>();

    // public int numDecodings(String s) {
    //     return recursiveMemo(0, s);
    // }

    // private int recursiveMemo(int index, String s) {
    //     // If the end of the string is reached, one valid decoding is found
    //     if (index == s.length()) {
    //         return 1;
    //     }

    //     // If the character at the current index is '0', it cannot be decoded
    //     if (s.charAt(index) == '0') {
    //         return 0;
    //     }

    //     // Check if this result is already computed
    //     if (memo.containsKey(index)) {
    //         return memo.get(index);
    //     }

    //     // Decode the single character
    //     int ways = recursiveMemo(index + 1, s);

    //     // Decode the two-character substring (if it’s within bounds and valid)
    //     if (index + 1 < s.length()) {
    //         int twoDigit = Integer.parseInt(s.substring(index, index + 2));
    //         if (twoDigit >= 10 && twoDigit <= 26) {
    //             ways += recursiveMemo(index + 2, s);
    //         }
    //     }

    //     // Store the result in the memoization map
    //     memo.put(index, ways);

    //     return ways;
    // }

    // Bottom-up (Tabulation)
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0; // No valid decoding for empty string or starting with '0'
        }

        int n = s.length();
        int[] dp = new int[n + 1];  // dp[i] stores ways to decode s[0...i-1]
        dp[0] = 1;  // Base case: one way to decode an empty string
        dp[1] = 1;  // One way to decode a non-'0' single character

        for (int i = 2; i <= n; i++) {
            // Single-digit check (s[i-1])
            int oneDigit = Integer.parseInt(s.substring(i - 1, i));
            if (oneDigit >= 1 && oneDigit <= 9) {
                dp[i] += dp[i - 1];
            }

            // Two-digit check (s[i-2]s[i-1])
            int twoDigits = Integer.parseInt(s.substring(i - 2, i));
            if (twoDigits >= 10 && twoDigits <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];  // Total ways to decode the entire string
    }
}
