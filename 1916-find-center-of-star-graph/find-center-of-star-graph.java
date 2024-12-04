class Solution {
    public int findCenter(int[][] edges) {
        int n = edges.length;
        HashMap<Integer, Integer> degrees = new HashMap<>();

        for (int[] edge : edges) {
            degrees.put(edge[0], degrees.getOrDefault(edge[0], 0) + 1);
            degrees.put(edge[1], degrees.getOrDefault(edge[1], 0) + 1);
            if (degrees.get(edge[0]) == n)
                return edge[0];
            if (degrees.get(edge[1]) == n)
                return edge[1];
        }

        return -1;
    }
}