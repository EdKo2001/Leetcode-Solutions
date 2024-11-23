/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int candidate = 0; // Assume person 0 is the celebrity
        
        // Step 1: Find the candidate
        for (int i = 1; i < n; i++) {
            if (knows(candidate, i)) {
                // If candidate knows i, candidate can't be the celebrity
                candidate = i;
            }
        }
        
        // Step 2: Verify the candidate
        for (int i = 0; i < n; i++) {
            if (i != candidate) { // Skip the candidate themselves
                // Check if the candidate knows anyone or someone doesn't know the candidate
                if (knows(candidate, i) || !knows(i, candidate)) {
                    return -1; // Not a celebrity
                }
            }
        }
        
        return candidate; // Candidate is the celebrity
    }
}
