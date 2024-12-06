class Solution {
    public int maxCount(int[] banned, int n, long maxSum) {
        Arrays.sort(banned);
        int bannedIndex = 0;
        int cnt = 0;

        for (int i = 1; i <= n; i++) {
            while (bannedIndex < banned.length && banned[bannedIndex] < i) {
                bannedIndex++;
            }
            if (bannedIndex < banned.length && banned[bannedIndex] == i) {
                continue;
            }

            if (maxSum - i < 0) {
                break;
            }

            maxSum -= i;
            cnt++;
        }

        return cnt;
    }
}