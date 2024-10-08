class KthLargest {
    int k;
    List<Integer> stream = new ArrayList<>();

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int i = 0; i < nums.length; i++) {
            stream.add(nums[i]);
        }
    }
    
    public int add(int val) {
        stream.add(val);
        Collections.sort(stream, Comparator.reverseOrder());
        return stream.get(k - 1);
    }
}


/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */