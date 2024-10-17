class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        // (Comparator.reverseOrder());

        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        while (maxHeap.size() > 1) {
            int stone1 = maxHeap.poll();
            int stone2 = maxHeap.poll();

            int res = stone1 - stone2;

            if (res > 0)
                maxHeap.offer(stone1 - stone2);
        }

        return maxHeap.size() == 1? maxHeap.peek() : 0;
    }
}