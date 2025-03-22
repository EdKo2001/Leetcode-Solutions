class Solution {

    public int minimumDistance(
        int n,
        List<List<Integer>> edges,
        int s,
        int[] marked
    ) {
        // Convert marked array to set for O(1) lookups
        Set<Integer> markSet = new HashSet<>();
        for (int node : marked) {
            markSet.add(node);
        }

        // Build adjacency list representation of the graph
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (List<Integer> edge : edges) {
            adj.get(edge.get(0)).add(new int[] { edge.get(1), edge.get(2) });
        }

        // Initialize distance array with infinity values
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;

        // Min heap prioritized by distance
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );
        minHeap.offer(new int[] { 0, s });

        // Dijkstra's algorithm
        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int node = current[1];
            int distance = current[0];

            // Found a marked node, return its distance
            if (markSet.contains(node)) {
                return dist[node];
            }

            // Explore neighbors
            for (int[] edge : adj.get(node)) {
                int nextNode = edge[0];
                int weight = edge[1];
                int newDist = distance + weight;

                // If we found a shorter path, update and add to the priority queue
                if (newDist < dist[nextNode]) {
                    dist[nextNode] = newDist;
                    minHeap.offer(new int[] { newDist, nextNode });
                }
            }
        }

        // No path found to any marked node
        return -1;
    }
}