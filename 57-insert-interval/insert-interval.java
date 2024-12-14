class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int newStart = newInterval[0], newEnd = newInterval[1];
        int i = 0, n = intervals.length;

        // Add all intervals that end before the new interval starts
        while (i < n && intervals[i][1] < newStart) {
            result.add(intervals[i]);
            i++;
        }

        // Merge overlapping intervals with the new interval
        while (i < n && intervals[i][0] <= newEnd) {
            newStart = Math.min(newStart, intervals[i][0]);
            newEnd = Math.max(newEnd, intervals[i][1]);
            i++;
        }
        result.add(new int[] { newStart, newEnd });

        // Add the remaining intervals
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        // Convert the result list back to a 2D array
        return result.toArray(new int[result.size()][]);
    }
}