class Solution {
    public int slidingPuzzle(int[][] board) {
        // Convert the board into a string representation
        StringBuilder startState = new StringBuilder();
        for (int[] row : board) {
            for (int num : row) {
                startState.append(num);
            }
        }
        String goal = "123450";

        // Possible moves based on the position of '0'
        int[][] moves = {
                { 1, 3 }, // Position 0 can move right or down
                { 0, 2, 4 }, // Position 1 can move left, right, or down
                { 1, 5 }, // Position 2 can move left or down
                { 0, 4 }, // Position 3 can move up or right
                { 1, 3, 5 }, // Position 4 can move up, left, or right
                { 2, 4 } // Position 5 can move up or left
        };

        // Initialize BFS
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(startState.toString());
        visited.add(startState.toString());

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currentState = queue.poll();
                if (currentState.equals(goal)) {
                    return steps;
                }

                int zeroIndex = currentState.indexOf('0'); // Find the empty space

                for (int move : moves[zeroIndex]) {
                    // Swap '0' with the adjacent tile to generate the new state
                    char[] nextStateArray = currentState.toCharArray();
                    swap(nextStateArray, zeroIndex, move);

                    String nextState = new String(nextStateArray);
                    if (!visited.contains(nextState)) {
                        queue.offer(nextState);
                        visited.add(nextState);
                    }
                }
            }
            steps++;
        }
        return -1; // If no solution is found
    }

    // Helper function to swap two characters in the array
    private void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}