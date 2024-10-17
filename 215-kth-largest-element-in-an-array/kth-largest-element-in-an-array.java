class Solution {
    public int findKthLargest(int[] nums, int k) {
        // PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // for (int num : nums) {
        // if (minHeap.size() < k || minHeap.peek() < num) {
        // minHeap.offer(num);
        // if (minHeap.size() > k) {
        // minHeap.poll();
        // }
        // }
        // }

        // return minHeap.peek();

        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;

        for (int num : nums) {
            minValue = Math.min(minValue, num);
            maxValue = Math.max(maxValue, num);
        }

        int[] count = new int[maxValue - minValue + 1];
        for (int num : nums) {
            count[num - minValue]++;
        }

        int remain = k;
        for (int num = count.length - 1; num >= 0; num--) {
            remain -= count[num];
            if (remain <= 0) {
                return num + minValue;
            }
        }

        return -1;
    }
}