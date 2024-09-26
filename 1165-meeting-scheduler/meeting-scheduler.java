class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        // Sort both slots by their start times
        Arrays.sort(slots1, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(slots2, (a, b) -> Integer.compare(a[0], b[0]));

        int slot1Pointer = 0;
        int slot2Pointer = 0;

        while (slot1Pointer < slots1.length && slot2Pointer < slots2.length) {
            // Find the overlap between the current slots of both persons
            int start = Math.max(slots1[slot1Pointer][0], slots2[slot2Pointer][0]);
            int end = Math.min(slots1[slot1Pointer][1], slots2[slot2Pointer][1]);

            // Check if the overlap can accommodate the required duration
            if (end - start >= duration) {
                return Arrays.asList(start, start + duration);
            }

            // Move the pointer that has the earlier ending time
            if (slots1[slot1Pointer][1] < slots2[slot2Pointer][1]) {
                slot1Pointer++;
            } else {
                slot2Pointer++;
            }
        }

        return new ArrayList<Integer>();
    }
}