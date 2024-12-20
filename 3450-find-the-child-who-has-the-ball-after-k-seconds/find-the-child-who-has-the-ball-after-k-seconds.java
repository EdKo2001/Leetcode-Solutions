class Solution {
    public int numberOfChild(int n, int k) {
        // Find the effective position in the oscillation period
        int period = 2 * (n - 1);
        int effectivePosition = k % period;

        // If within the ascending part of the period
        if (effectivePosition <= n - 1) {
            return effectivePosition;
        }
        // If within the descending part of the period
        return period - effectivePosition;
    }
}
