class Solution {
    public int rearrangeCharacters(String s, String target) {
        int[] sFreq = new int[26];
        int[] targetFreq = new int[26];

        for (char ch : s.toCharArray()) {
            sFreq[ch - 'a']++;
        }

        for (char ch : target.toCharArray()) {
            targetFreq[ch - 'a']++;
        }

        int minCharFreq = Integer.MAX_VALUE;
        for (char ch : target.toCharArray()) {
            int targetCount = targetFreq[ch - 'a'];
            if (targetCount > 0) {
                minCharFreq = Math.min(minCharFreq, sFreq[ch - 'a'] / targetCount);
            }
        }
        return minCharFreq;
    }
}
