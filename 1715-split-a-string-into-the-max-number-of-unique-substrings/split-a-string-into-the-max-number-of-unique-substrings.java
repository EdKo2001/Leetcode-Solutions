class Solution {

    public int maxUniqueSplit(String s) {
        Set<String> seen = new HashSet<>();
        int[] maxCount = new int[1];
        backtrack(s, 0, seen, 0, maxCount);
        return maxCount[0];
    }

    private void backtrack(
            String s,
            int start,
            Set<String> seen,
            int count,
            int[] maxCount) {
        // Prune: If the current count plus remaining characters can't exceed maxCount,
        // return
        if (count + (s.length() - start) <= maxCount[0])
            return;

        // Base case: If we reach the end of the string, update maxCount
        if (start == s.length()) {
            maxCount[0] = Math.max(maxCount[0], count);
            return;
        }

        // Try every possible substring starting from 'start'
        for (int end = start + 1; end <= s.length(); ++end) {
            String substring = s.substring(start, end);
            // If the substring is unique
            if (!seen.contains(substring)) {
                // Add the substring to the seen set
                seen.add(substring);
                // Recursively count unique substrings from the next position
                backtrack(s, end, seen, count + 1, maxCount);
                // Backtrack: remove the substring from the seen set
                seen.remove(substring);
            }
        }
    }
}