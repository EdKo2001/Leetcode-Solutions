class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<Pair<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> {
            int valueComparison = Integer.compare(a.getKey(), b.getKey());
            if (valueComparison == 0) {
                return Integer.compare(a.getValue(), b.getValue());
            }
            return valueComparison;
        });

        for (int i = 0; i < nums.length; i++) {
            minHeap.offer(new Pair<>(nums[i], i));
        }

        while (k > 0) {
            Pair<Integer, Integer> pair = minHeap.poll();
            if (pair == null)
                break;

            int value = pair.getKey();
            int idx = pair.getValue();
            nums[idx] = value * multiplier;
            minHeap.offer(new Pair<>(nums[idx], idx));
            k--;
        }

        return nums;
    }
}