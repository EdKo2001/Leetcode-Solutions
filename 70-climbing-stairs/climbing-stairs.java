class Solution {
    private int[] cache; // Array to store the results of subproblems

    public int climbStairs(int n) {
        // Initialize the cache array with size n + 1 (to hold results from 0 to n)
        cache = new int[n + 1];
        // Fill the cache with -1 to indicate uncomputed states
        for (int i = 0; i < cache.length; i++) {
            cache[i] = -1;
        }
        return dp(0, n);
    }

    public int dp(int num, int target) {
        // Base case: if we reach the target, there's one way to stay there
        if (num == target) {
            return 1;
        }
        // If we exceed the target, no valid way
        if (num > target) {
            return 0;
        }
        // Check if the result is already computed and stored in cache
        if (cache[num] != -1) {
            return cache[num]; // Return cached result
        }
        // Compute the result and store it in the cache
        cache[num] = dp(num + 1, target) + dp(num + 2, target);
        return cache[num]; // Return the computed result
    }
}
