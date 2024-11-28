class Solution {
    public boolean canJump(int[] nums) {
        // int maxReach = 0;

        // for (int i = 0; i < nums.length; i++) {
        //     if (i > maxReach) {
        //         return false;
        //     }
        //     maxReach = Math.max(maxReach, i + nums[i]);
        //     if (maxReach >= nums.length - 1) {
        //         return true;
        //     }
        // }

        // return false;

        int n = nums.length;
        boolean[] visited = new boolean[n]; // To avoid revisiting indices
        Queue<Integer> queue = new LinkedList<>();
        
        queue.offer(0); // Start from index 0
        visited[0] = true;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            // If we reach the last index
            if (current == n - 1) {
                return true;
            }
            
            // Explore all reachable indices from the current index
            for (int next = current + 1; next <= current + nums[current] && next < n; next++) {
                if (!visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                }
            }
        }
        
        return false; // If all possibilities are exhausted without reaching the end
    }
}
