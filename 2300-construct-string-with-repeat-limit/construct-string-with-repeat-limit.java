class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                maxHeap.offer(new int[] { i, freq[i] });
            }
        }

        StringBuilder result = new StringBuilder();

        while (!maxHeap.isEmpty()) {
            int[] largest = maxHeap.poll();
            char currChar = (char) (largest[0] + 'a');
            int currFreq = largest[1];

            int timesToAdd = Math.min(repeatLimit, currFreq);
            for (int i = 0; i < timesToAdd; i++) {
                result.append(currChar);
            }

            currFreq -= timesToAdd;

            if (currFreq > 0) {
                if (maxHeap.isEmpty()) {
                    break;
                }
                int[] secondLargest = maxHeap.poll();
                char nextChar = (char) (secondLargest[0] + 'a');
                int nextFreq = secondLargest[1];

                result.append(nextChar);
                nextFreq--;

                if (nextFreq > 0) {
                    maxHeap.offer(new int[] { secondLargest[0], nextFreq });
                }
                maxHeap.offer(new int[] { largest[0], currFreq });
            }
        }

        return result.toString();
    }
}