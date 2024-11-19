class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long max = 0;
        long prefixSum = 0;
        
        // HashMap to store the frequency of elements in the current window
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        
        // Initialize the first window of size k
        for (int i = 0; i < k; i++) {
            int curr = nums[i];
            frequencyMap.put(curr, frequencyMap.getOrDefault(curr, 0) + 1);
            prefixSum += curr;
        }
        
        // If the window contains exactly k unique elements, we update max
        if (frequencyMap.size() == k) {
            max = Math.max(max, prefixSum);
        }
        
        // Slide the window across the array
        for (int i = k; i < nums.length; i++) {
            int left = nums[i - k];
            int right = nums[i];
            
            // Remove the element that is leaving the window
            frequencyMap.put(left, frequencyMap.get(left) - 1);
            if (frequencyMap.get(left) == 0) {
                frequencyMap.remove(left);
            }
            prefixSum -= left;

            // Add the new element that is entering the window
            frequencyMap.put(right, frequencyMap.getOrDefault(right, 0) + 1);
            prefixSum += right;

            // If the window contains exactly k unique elements, check the sum
            if (frequencyMap.size() == k) {
                max = Math.max(max, prefixSum);
            }
        }
        
        return max;
    }
}
