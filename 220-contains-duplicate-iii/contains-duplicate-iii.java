class Solution {
    // Get the ID of the bucket from element value x and bucket width w
    // Java's division `/` rounds towards zero, but we need floor division for
    // correct bucketing.
    private long getID(long x, long w) {
        return Math.floorDiv(x, w);
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (t < 0)
            return false;
        Map<Long, Long> buckets = new HashMap<>();
        long w = (long) t + 1;
        for (int i = 0; i < nums.length; ++i) {
            long bucket = getID(nums[i], w);
            // check if current bucket is empty, each bucket may contain at most one element
            if (buckets.containsKey(bucket))
                return true;
            // check the neighbor buckets for almost duplicate
            if (buckets.containsKey(bucket - 1) &&
                    Math.abs(nums[i] - buckets.get(bucket - 1)) < w)
                return true;
            if (buckets.containsKey(bucket + 1) &&
                    Math.abs(nums[i] - buckets.get(bucket + 1)) < w)
                return true;
            // now bucket is empty and no almost duplicate in neighbor buckets
            buckets.put(bucket, (long) nums[i]);
            if (i >= k)
                buckets.remove(getID(nums[i - k], w));
        }
        return false;
    }
}