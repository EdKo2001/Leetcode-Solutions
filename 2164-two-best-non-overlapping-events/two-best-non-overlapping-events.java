class Solution {
    public int maxTwoEvents(int[][] events) {
        // Step 1: Sort events by their end time
        Arrays.sort(events, Comparator.comparingInt(a -> a[1]));

        // To keep track of maximum value up to the current event
        int[] maxUpTo = new int[events.length];

        // Extract end times for binary search
        int[] endTimes = new int[events.length];
        for (int i = 0; i < events.length; i++) {
            endTimes[i] = events[i][1];
        }

        int maxValue = 0;
        int result = 0;

        for (int i = 0; i < events.length; i++) {
            int start = events[i][0], value = events[i][2];

            // Find the last event that ends before this event starts
            int index = binarySearch(endTimes, start);

            // Calculate maximum value considering two events
            int currentMax = value;
            if (index != -1) {
                currentMax += maxUpTo[index];
            }

            // Update the result
            result = Math.max(result, currentMax);

            // Update the max value up to this point
            maxValue = Math.max(maxValue, value);
            maxUpTo[i] = maxValue;
        }

        return result;
    }

    // Binary search for the last event that ends before `startTime`
    private int binarySearch(int[] endTimes, int startTime) {
        int low = 0, high = endTimes.length - 1;
        int result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (endTimes[mid] < startTime) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }
}