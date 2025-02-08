class Solution {

    public int makePrefSumNonNegative(int[] nums) {
        int operations = 0;
        long prefixSum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : nums) {
            // Push negative elements to the min heap.
            if (num < 0) {
                pq.offer(num);
            }

            prefixSum += num;
            // Pop the minimum element from the heap and subtract from the sum.
            if (prefixSum < 0) {
                prefixSum -= pq.poll();
                // Increment the operations required.
                operations++;
            }
        }

        return operations;
    }
}