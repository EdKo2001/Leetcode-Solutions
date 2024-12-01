class Solution {
    public int minSetSize(int[] arr) {
        // Step 1: Count frequencies of each number
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create a max-heap (priority queue) based on frequencies
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int freq : freqMap.values()) {
            maxHeap.offer(freq);
        }

        // Step 3: Remove elements from the heap until we reduce the array size by half
        int removedElements = 0;
        int sizeReduced = 0;
        int targetSize = arr.length / 2;

        while (sizeReduced < targetSize) {
            sizeReduced += maxHeap.poll(); // Remove the most frequent element
            removedElements++;
        }

        return removedElements; // Minimum number of set removals
    }
}