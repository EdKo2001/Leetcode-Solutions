class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] memo = new int[text1.length()][text2.length()];
        // Initialize the memo array with -1 to indicate uncalculated subproblems
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[0].length; j++) {
                memo[i][j] = -1;
            }
        }
        return helper(text1, text2, 0, 0, memo);
    }

    public int helper(String text1, String text2, int i, int j, int[][] memo) {
        // Base case: if we reach the end of either string, return 0
        if (i >= text1.length() || j >= text2.length()) {
            return 0;
        }
        // If the subproblem has already been solved, return the stored result
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        // If characters match, increment the LCS length and move both pointers
        if (text1.charAt(i) == text2.charAt(j)) {
            memo[i][j] = 1 + helper(text1, text2, i + 1, j + 1, memo);
        } else {
            // Otherwise, take the maximum of either skipping one character from text1 or
            // text2
            memo[i][j] = Math.max(helper(text1, text2, i + 1, j, memo), helper(text1, text2, i, j + 1, memo));
        }

        return memo[i][j];
    }
}
