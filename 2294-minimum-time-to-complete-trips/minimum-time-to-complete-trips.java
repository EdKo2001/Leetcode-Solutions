class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        Arrays.sort(time);
        long left = 1;
        long right = (long) time[0] * totalTrips;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long totalTripsForMid = 0;

            // Calculate total trips for the current time mid
            for (int t : time) {
                totalTripsForMid += mid / t;
                if (totalTripsForMid >= totalTrips) {
                    break; // Early exit if we've already met the target
                }
            }

            if (totalTripsForMid >= totalTrips) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
