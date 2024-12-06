class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> bannedSet = new HashSet<>();
        for (int num : banned) {
            bannedSet.add(num);
        }

        int cnt = 0;

        for (int i = 1; i <= n; i++) {
            if (maxSum - i < 0)
                break;
            if (!bannedSet.contains(i)) {
                cnt++;
                maxSum -= i;
            }
        }

        return cnt;

    }
}