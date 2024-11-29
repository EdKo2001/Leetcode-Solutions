class Solution {
    public int jump(int[] nums) {
        // TLE
        int n = nums.length;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];

        queue.offer(new Pair<>(0, 0));
        visited[0] = true;

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> current = queue.poll();
            int idx = current.getKey();
            int val = current.getValue();

            // If we reach the last index
            if (idx == n - 1) {
                return val;
            }

            // Explore all reachable indices from the current index
            for (int next = idx + 1; next <= idx + nums[idx] && next < n; next++) {
                if (!visited[next]) {
                    queue.offer(new Pair<>(next, val + 1));
                    visited[next] = true;
                }
            }
        }

        return 0;

        // int jumps = 0;
        // int currentEnd = 0;
        // int farthest = 0;

        // for (int i = 0; i < nums.length - 1; i++) {
        // farthest = Math.max(farthest, i + nums[i]);

        // if (i == currentEnd) {
        // jumps++;
        // currentEnd = farthest;
        // }
        // }

        // return jumps;
    }
}