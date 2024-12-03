class Solution {
    public int[][] merge(int[][] intervals) {
        // Sort intervals based on the start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Use a dynamic list to store merged intervals
        List<int[]> merged = new ArrayList<>();

        // Initialize with the first interval
        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= end) {
                // Overlapping intervals: merge them
                end = Math.max(end, intervals[i][1]);
            } else {
                // No overlap: add the previous interval and update pointers
                merged.add(new int[] { start, end });
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        // Add the last interval
        merged.add(new int[] { start, end });

        // Convert the list to an array
        return merged.toArray(new int[merged.size()][]);
    }
}