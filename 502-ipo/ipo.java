class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        // Min-heap to store projects by their capital requirements
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                (a, b) -> a[0] - b[0] // Compare based on capital
        );

        // Max-heap to store projects by their profit
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> b[1] - a[1] // Compare based on profit
        );

        // Add all projects to the min-heap with [capital, profit] as elements
        for (int i = 0; i < profits.length; i++) {
            minHeap.offer(new int[] { capital[i], profits[i] });
        }

        // Process up to k projects
        for (int i = 0; i < k; i++) {
            // Transfer all projects that can be started with current capital to the
            // max-heap
            while (!minHeap.isEmpty() && minHeap.peek()[0] <= w) {
                maxHeap.offer(minHeap.poll());
            }

            // If we can't start any project, break early
            if (maxHeap.isEmpty()) {
                break;
            }

            // Select the project with the highest profit
            w += maxHeap.poll()[1];
        }

        return w;
    }
}