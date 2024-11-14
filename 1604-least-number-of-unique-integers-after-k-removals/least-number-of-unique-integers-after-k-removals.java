class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        // Step 1: Build frequency map
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Step 2: Collect and sort frequencies in ascending order
        List<Integer> frequencies = new ArrayList<>(freq.values());
        Collections.sort(frequencies);

        // Step 3: Remove elements by frequency until k is used up
        int uniqueCount = frequencies.size();
        for (int count : frequencies) {
            if (k >= count) {
                k -= count; // Use up `k` on this frequency
                uniqueCount--; // One less unique integer
            } else {
                break; // Stop if `k` is not enough to remove the next group
            }
        }

        return uniqueCount;
    }
}