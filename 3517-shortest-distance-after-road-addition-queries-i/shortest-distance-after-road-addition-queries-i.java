class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        // Adjacency list to store the roads
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Initialize the default roads: 0 -> 1 -> 2 -> ... -> n-1
        for (int i = 0; i < n - 1; i++) {
            graph.get(i).add(i + 1);
        }

        int[] res = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];

            // Add the new road from u to v
            graph.get(u).add(v);

            // Perform BFS to find the shortest path from 0 to n-1
            res[i] = bfs(graph, n);
        }

        return res;
    }

    // BFS function to compute the shortest distance from city 0 to city n-1
    private int bfs(ArrayList<ArrayList<Integer>> graph, int n) {
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        int[] distance = new int[n];

        // Start BFS from city 0
        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int neighbor : graph.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    distance[neighbor] = distance[current] + 1;
                    queue.add(neighbor);

                    // If we reached the destination city n-1
                    if (neighbor == n - 1) {
                        return distance[neighbor];
                    }
                }
            }
        }

        return -1; // If n-1 is unreachable (shouldn't happen in valid inputs)
    }
}
