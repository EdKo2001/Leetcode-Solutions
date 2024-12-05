class Solution {
    public boolean canChange(String start, String target) {
        // First, remove all underscores and compare the sequences of L and R
        String startWithoutUnderscore = start.replace("_", "");
        String targetWithoutUnderscore = target.replace("_", "");

        if (!startWithoutUnderscore.equals(targetWithoutUnderscore)) {
            return false; // The sequence of L and R characters must be the same
        }

        int startPointer = 0;
        int targetPointer = 0;

        while (startPointer < start.length() && targetPointer < target.length()) {
            // Move startPointer and targetPointer to the next non-underscore character
            while (startPointer < start.length() && start.charAt(startPointer) == '_') {
                startPointer++;
            }
            while (targetPointer < target.length() && target.charAt(targetPointer) == '_') {
                targetPointer++;
            }

            // Check if we have reached the end
            if (startPointer == start.length() && targetPointer == target.length()) {
                return true;
            }

            // Ensure characters are the same
            if (start.charAt(startPointer) != target.charAt(targetPointer)) {
                return false;
            }

            // Verify the movement constraints:
            if (start.charAt(startPointer) == 'L' && startPointer < targetPointer) {
                return false; // 'L' can only move to the left
            }
            if (start.charAt(startPointer) == 'R' && startPointer > targetPointer) {
                return false; // 'R' can only move to the right
            }

            // Move to the next characters
            startPointer++;
            targetPointer++;
        }

        return true;
    }
}
