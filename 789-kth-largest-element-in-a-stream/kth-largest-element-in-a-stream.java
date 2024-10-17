class KthLargest {
    // int k;
    // List<Integer> stream = new ArrayList<>();

    // public KthLargest(int k, int[] nums) {
    // this.k = k;
    // for(int i = 0; i < nums.length; i++) {
    // stream.add(nums[i]);
    // }
    // }

    // public int add(int val) {
    // stream.add(val);
    // Collections.sort(stream, Comparator.reverseOrder());
    // return stream.get(k - 1);
    // }

    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        // minHeap.offer(val);
        // if (minHeap.size() > k) {
        // minHeap.poll();
        // }
        // return minHeap.peek();

        // Add to our minHeap if we haven't processed k elements yet
        // or if val is greater than the top element (the k-th largest)
        if (minHeap.size() < k || minHeap.peek() < val) {
            minHeap.add(val);
            if (minHeap.size() > k) {
                minHeap.remove();
            }
        }
        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */