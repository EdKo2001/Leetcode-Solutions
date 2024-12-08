class Solution {

    public int maxLength(int[] ribbons, int k) {
        // Binary search bounds
        int left = 0;
        int right = Arrays.stream(ribbons).max().getAsInt();

        // Perform binary search on the ribbon length
        while (left < right) {
            int middle = (left + right + 1) / 2; // Use upper mid to prevent infinite loops
            if (isPossible(middle, ribbons, k)) {
                // If it's possible to make `k` pieces of length `middle`, search the higher
                // range
                left = middle;
            } else {
                // Otherwise, search the lower range
                right = middle - 1;
            }
        }
        return left;
    }

    // Helper function to determine if it's possible to cut the ribbons into at
    // least `k` pieces
    // of the given `x`
    private boolean isPossible(int x, int[] ribbons, int k) {
        int totalRibbons = 0;
        for (int ribbon : ribbons) {
            // Number of pieces the current ribbon can contribute
            totalRibbons += ribbon / x;
            // If the total reaches or exceeds `k`, we can stop early
            if (totalRibbons >= k) {
                return true;
            }
        }
        // It's not possible to make the cut
        return false;
    }
}