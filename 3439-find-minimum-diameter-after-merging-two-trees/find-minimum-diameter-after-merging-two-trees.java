class Solution {

    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        // Calculate the number of nodes for each tree
        int n = edges1.length + 1;
        int m = edges2.length + 1;

        // Build adjacency lists for both trees
        List<List<Integer>> adjList1 = buildAdjList(n, edges1);
        List<List<Integer>> adjList2 = buildAdjList(m, edges2);

        // Calculate the diameters of both trees
        int diameter1 = findDiameter(n, adjList1);
        int diameter2 = findDiameter(m, adjList2);

        // Calculate the longest path that spans across both trees
        int combinedDiameter =
            (int) Math.ceil(diameter1 / 2.0) +
            (int) Math.ceil(diameter2 / 2.0) +
            1;

        // Return the maximum of the three possibilities
        return Math.max(Math.max(diameter1, diameter2), combinedDiameter);
    }

    private List<List<Integer>> buildAdjList(int size, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        return adjList;
    }

    private int findDiameter(int n, List<List<Integer>> adjList) {
        // First BFS to find the farthest node from an arbitrary node (e.g., 0)
        Pair firstBFS = findFarthestNode(n, adjList, 0);
        int farthestNode = firstBFS.getFirst();

        // Second BFS to find the diameter starting from the farthest node
        Pair secondBFS = findFarthestNode(n, adjList, farthestNode);
        return secondBFS.getSecond();
    }

    private Pair findFarthestNode(
        int n,
        List<List<Integer>> adjList,
        int sourceNode
    ) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        // Push source node into the queue
        queue.add(sourceNode);
        visited[sourceNode] = true;

        int maximumDistance = 0, farthestNode = sourceNode;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int currentNode = queue.poll();
                // Update farthest node
                // The farthest node is the last one that was popped out of the
                // queue.
                farthestNode = currentNode;

                // Explore neighbors
                for (int neighbor : adjList.get(currentNode)) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.add(neighbor);
                    }
                }
            }
            if (!queue.isEmpty()) maximumDistance++;
        }
        return new Pair(farthestNode, maximumDistance);
    }

    // Simple Pair class for storing results of findFarthestNode function
    class Pair {

        private int first;
        private int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        public int getFirst() {
            return first;
        }

        public int getSecond() {
            return second;
        }
    }
}