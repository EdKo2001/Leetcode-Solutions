class Solution {
    public int[] distanceToCycle(int n, int[][] edges) {
        // Initialize helper structures
        boolean[] isInCycle = new boolean[n];
        Arrays.fill(isInCycle, true); // Assume all nodes are part of a cycle initially
        int[] degree = new int[n];
        int[] distances = new int[n];
        List<List<Integer>> adjacencyList = new ArrayList<>();

        // Build the adjacency list and calculate node degrees
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        // Add all leaf nodes (degree 1) to the queue for removal
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                queue.add(i);
            }
        }

        // Remove non-cycle nodes
        while (!queue.isEmpty()) {
            int current = queue.poll();
            isInCycle[current] = false; // Mark node as not in cycle

            // Reduce degree of neighbors and enqueue new leaves
            for (int neighbor : adjacencyList.get(current)) {
                degree[neighbor]--;
                if (degree[neighbor] == 1) {
                    queue.add(neighbor);
                }
            }
        }

        // BFS from cycle nodes to calculate distances
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (isInCycle[i]) {
                queue.add(i);
                visited[i] = true;
            }
        }

        int distance = 0;
        while (!queue.isEmpty()) {
            int size = queue.size(); // Process nodes at the current distance level
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                distances[current] = distance;

                for (int neighbor : adjacencyList.get(current)) {
                    if (!visited[neighbor]) {
                        queue.add(neighbor);
                        visited[neighbor] = true;
                    }
                }
            }
            distance++; // Increment distance for the next level
        }

        return distances;
    }
}
