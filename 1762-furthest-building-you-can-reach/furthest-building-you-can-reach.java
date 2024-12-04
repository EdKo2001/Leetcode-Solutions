class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // Store the jumps

        for (int i = 0; i < heights.length - 1; i++) {
            int diff = heights[i + 1] - heights[i];

            if (diff > 0) {
                minHeap.add(diff); // Add current climb height to the heap

                if (minHeap.size() > ladders) { // If we use more than available ladders
                    bricks -= minHeap.poll(); // Use bricks for the smallest ladder used

                    if (bricks < 0) { // If out of bricks, we can't move further
                        return i;
                    }
                }
            }
        }

        return heights.length - 1; // Reached the last building
    }
}