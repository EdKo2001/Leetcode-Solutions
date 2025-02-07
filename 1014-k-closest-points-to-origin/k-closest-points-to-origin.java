class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<Integer> maxHeap = new PriorityQueue<>(
                (a, b) -> (points[b][0] * points[b][0] + points[b][1] * points[b][1])
                        - (points[a][0] * points[a][0] + points[a][1] * points[a][1]));

        for (int i = 0; i < points.length; i++) {
            maxHeap.offer(i);

            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] res = new int[k][2];
        int resIdx = 0;
        for (int i = 0; i < k; i++) {
            res[resIdx++] = points[maxHeap.poll()];
        }
        return res;
    }
}