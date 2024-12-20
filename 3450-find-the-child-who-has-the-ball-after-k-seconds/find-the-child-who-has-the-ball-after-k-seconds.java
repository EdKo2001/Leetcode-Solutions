class Solution {
    public int numberOfChild(int n, int k) {
        int ans = 0;
        boolean plus = true;

        // Calculate the oscillation period
        int period = 2 * (n - 1);

        // Find the effective position in the current oscillation period
        int effectiveK = k % period;

        // Iterate only up to the effective position
        for (int i = 1; i <= effectiveK; i++) {
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
