class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (k == nums.length) {
            return nums;
        }

        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        Queue<Integer> minHeap = new PriorityQueue<>(
                (n1, n2) -> count.get(n1) - count.get(n2));

        for (int n : count.keySet()) {
            minHeap.add(n);
            if (minHeap.size() > k)
                minHeap.poll();
        }

        int[] top = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            top[i] = minHeap.poll();
        }
        return top;
    }
}