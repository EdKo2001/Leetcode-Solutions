class Solution {
    public int[] findBuildings(int[] heights) {
        int n = heights.length;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int maxSeen = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (heights[i] > maxSeen) {
                minHeap.offer(i);
                maxSeen = heights[i];
            }
        }

        int[] res = new int[minHeap.size()];
        int resIndex = 0;
        while (!minHeap.isEmpty()) {
            res[resIndex++] = minHeap.poll();
        }
        return res;
    }
}