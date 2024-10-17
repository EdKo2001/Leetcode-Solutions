class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Use a PriorityQueue that orders points based on their distance from the
        // origin
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                (p1, p2) -> Double.compare(distance(p1), distance(p2)));

        // Add all points to the heap
        for (int[] point : points) {
            minHeap.offer(point);
        }

        // Collect the k closest points
        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            res[i] = minHeap.poll();
        }

        return res;
    }

    // Helper method to calculate the distance from the origin
    private double distance(int[] point) {
        return Math.sqrt(Math.pow(point[0], 2) + Math.pow(point[1], 2));
    }
}
