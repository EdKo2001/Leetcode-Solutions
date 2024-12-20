class Solution {
    public int numberOfChild(int n, int k) {
        int ans = 0;
        boolean plus = true;
        for (int i = 1; i <= k; i++) {
            if (plus) {
                ans++;
                if (ans == n - 1) {
                    plus = false;
                }
            } else {
                ans--;
                if (ans == 0) {
                    plus = true;
                }
            }
        }
        return ans;
    }
}