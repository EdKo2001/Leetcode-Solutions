class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int lo = Arrays.stream(weights).max().getAsInt();
        int hi = Arrays.stream(weights).sum();

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (feasable(weights, days, mid)) {
                hi = mid;
            } else {
                lo = ++mid;
            }
        }

        return lo;
    }

    private static boolean feasable(int[] weights, int days, int capacity) {
        int daysCnt = 1;
        int capacityCnt = 0;
        for (int weight : weights) {
            if (capacityCnt + weight > capacity) {
                capacityCnt = weight;
                daysCnt++;
            } else {
                capacityCnt += weight;
            }
        }
        return daysCnt <= days;
    }
}