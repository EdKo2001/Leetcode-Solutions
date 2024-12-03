class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        minHeap.offer(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < minHeap.peek()) {
                minHeap.offer(intervals[i][1]);
            } else {
                minHeap.poll();
                minHeap.offer(intervals[i][1]);
            }
        }

        return minHeap.size();
    }
}