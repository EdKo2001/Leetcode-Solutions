import java.util.*;

class Solution {
    private int[] memo;

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        // Create an adjacency list to store subordinates for each employee
        List<List<Integer>> subordinates = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            subordinates.add(new ArrayList<>());
        }

        // Populate the adjacency list
        for (int i = 0; i < n; i++) {
            if (manager[i] != -1) { // If not the head (headID has no manager)
                subordinates.get(manager[i]).add(i);
            }
        }

        // Initialize the memoization array
        memo = new int[n];
        Arrays.fill(memo, -1);  // -1 indicates that the time hasn't been computed yet

        // Start DFS from the headID and compute the inform time
        return dfs(headID, subordinates, informTime);
    }

    private int dfs(int employee, List<List<Integer>> subordinates, int[] informTime) {
        // If the inform time has already been computed, return the cached value
        if (memo[employee] != -1) {
            return memo[employee];
        }

        int totalTime = 0;

        // Explore each subordinate and compute the total time to inform them
        for (int subordinate : subordinates.get(employee)) {
            totalTime = Math.max(totalTime, dfs(subordinate, subordinates, informTime));
        }

        // Memoize the result: the total time to inform all subordinates of this employee
        memo[employee] = totalTime + informTime[employee];
        return memo[employee];
    }
}
