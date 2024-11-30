class Solution {

    public int[][] validArrangement(int[][] pairs) {
        HashMap<Integer, LinkedList<Integer>> adjacencyMatrix = new HashMap<>();
        HashMap<Integer, Integer> inDegree = new HashMap<>(), outDegree = new HashMap<>();

        // Build the adjacency list and track in-degrees and out-degrees
        for (int[] pair : pairs) {
            int start = pair[0], end = pair[1];
            adjacencyMatrix.putIfAbsent(start, new LinkedList<>());
            adjacencyMatrix.get(start).add(end);
            outDegree.put(start, outDegree.getOrDefault(start, 0) + 1);
            inDegree.put(end, inDegree.getOrDefault(end, 0) + 1);
        }

        ArrayList<Integer> result = new ArrayList<>();

        // Find the start node (outDegree == inDegree + 1)
        int startNode = -1;
        for (int node : outDegree.keySet()) {
            if (outDegree.get(node) == inDegree.getOrDefault(node, 0) + 1) {
                startNode = node;
                break;
            }
        }

        // If no such node exists, start from the first pair's first element
        if (startNode == -1) {
            startNode = pairs[0][0];
        }

        Stack<Integer> nodeStack = new Stack<>();
        nodeStack.push(startNode);

        // Iterative DFS using stack
        while (!nodeStack.empty()) {
            int node = nodeStack.peek();
            if (adjacencyMatrix.getOrDefault(node, new LinkedList<>()).size() > 0) {
                // Visit the next node
                int nextNode = adjacencyMatrix.get(node).removeFirst();
                nodeStack.push(nextNode);
            } else {
                // No more neighbors to visit, add node to result
                result.add(node);
                nodeStack.pop();
            }
        }

        // Reverse the result since we collected nodes in reverse order
        Collections.reverse(result);

        // Construct the result pairs
        int[][] pairedResult = new int[result.size() - 1][2];
        for (int i = 1; i < result.size(); ++i) {
            pairedResult[i - 1][0] = result.get(i - 1);
            pairedResult[i - 1][1] = result.get(i);
        }

        return pairedResult;
    }
}