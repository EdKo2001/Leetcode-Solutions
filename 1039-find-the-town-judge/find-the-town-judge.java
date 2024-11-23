class Solution {
    public int findJudge(int n, int[][] trust) {
        if (trust.length < n - 1) {
            return -1;
        }

        int[] trusts = new int[n + 1];
        int[] trusted = new int[n + 1];

        for (int[] tr : trust) {
            trusts[tr[0]]++;
            trusted[tr[1]]++;
        }

        for (int i = 1; i <= n; i++) {
            if (trusts[i] == 0 && trusted[i] == n - 1)
                return i;
        }

        return -1;
    }
}