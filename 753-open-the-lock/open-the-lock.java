class Solution {
    public int openLock(String[] deadends, String target) {
        int cnt = 0;

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        // Add deadends to the visited set
        for (String deadend : deadends) {
            visited.add(deadend);
        }

        // Early exit if initial state or target is a deadend
        if (visited.contains("0000"))
            return -1;
        if (target.equals("0000"))
            return 0;

        queue.offer("0000");
        visited.add("0000");

        while (!queue.isEmpty()) {
            int size = queue.size(); // Process each level
            for (int i = 0; i < size; i++) {
                String combination = queue.poll();

                // If the target is reached, return the count
                if (combination.equals(target)) {
                    return cnt;
                }

                // Generate all possible next states
                for (String next : getNextStates(combination)) {
                    if (!visited.contains(next)) {
                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }
            cnt++; // Increment the move count after processing one level
        }

        return -1; // If the target is not reachable
    }

    // Helper method to generate all possible next states
    private List<String> getNextStates(String combination) {
        List<String> nextStates = new ArrayList<>();
        char[] current = combination.toCharArray();

        for (int i = 0; i < 4; i++) {
            char original = current[i];

            // Turn the dial up
            current[i] = (char) ((original - '0' + 1) % 10 + '0');
            nextStates.add(new String(current));

            // Turn the dial down
            current[i] = (char) ((original - '0' + 9) % 10 + '0');
            nextStates.add(new String(current));

            // Restore the original character
            current[i] = original;
        }

        return nextStates;
    }
}
