/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    private int[][] cache; // Cache to store knows(a, b) results

    public int findCelebrity(int n) {
        cache = new int[n][n]; // Initialize the cache array with default value 0 (0: uninitialized)

        int candidate = 0; // Assume person 0 is the celebrity
        
        // Step 1: Find the candidate
        for (int i = 1; i < n; i++) {
            if (knowsWithCache(candidate, i)) {
                // If candidate knows i, candidate can't be the celebrity
                candidate = i;
            }
        }
        
        // Step 2: Verify the candidate
        for (int i = 0; i < n; i++) {
            if (i != candidate) { // Skip the candidate themselves
                // Check if the candidate knows anyone or someone doesn't know the candidate
                if (knowsWithCache(candidate, i) || !knowsWithCache(i, candidate)) {
                    return -1; // Not a celebrity
                }
            }
        }
        
        return candidate; // Candidate is the celebrity
    }
    
    // Cached version of the knows method
    private boolean knowsWithCache(int a, int b) {
        if (cache[a][b] == 0) { // Not initialized
            cache[a][b] = knows(a, b) ? 1 : -1; // Store 1 for true, -1 for false
        }
        return cache[a][b] == 1;
    }
}
