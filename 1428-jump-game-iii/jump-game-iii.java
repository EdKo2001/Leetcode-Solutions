class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        boolean[] visited = new boolean[n];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int currentIdx = queue.poll();

            if (visited[currentIdx])
                continue;

            visited[currentIdx] = true;

            if (arr[currentIdx] == 0)
                return true;

            if (currentIdx + arr[currentIdx] < n)
                queue.offer(currentIdx + arr[currentIdx]);

            if (currentIdx - arr[currentIdx] >= 0)
                queue.offer(currentIdx - arr[currentIdx]);
        }

        return false;
    }
}
