class Solution {

    public long minimumTotalDistance(List<Integer> robots, int[][] factories) {
        // Sort robots and factories by position
        Collections.sort(robots);
        Arrays.sort(factories, Comparator.comparingInt(a -> a[0]));

        // Flatten factory positions according to their capacities
        List<Integer> factoryPositions = new ArrayList<>();
        for (int[] factory : factories) {
            for (int i = 0; i < factory[1]; i++) {
                factoryPositions.add(factory[0]);
            }
        }

        int robotCount = robots.size(), factoryCount = factoryPositions.size();
        long[] next = new long[factoryCount + 1];
        long[] current = new long[factoryCount + 1];

        // Fill DP table using two rows for optimization
        for (int i = robotCount - 1; i >= 0; i--) {
            // No factories left case
            if (i != robotCount - 1)
                next[factoryCount] = (long) 1e12;
            // Initialize current row
            current[factoryCount] = (long) 1e12;

            for (int j = factoryCount - 1; j >= 0; j--) {
                // Assign current robot to current factory
                long assign = Math.abs((long) robots.get(i) - factoryPositions.get(j)) +
                        next[j + 1];
                // Skip current factory for this robot
                long skip = current[j + 1];
                // Take the minimum option
                current[j] = Math.min(assign, skip);
            }
            // Move to next robot
            System.arraycopy(current, 0, next, 0, factoryCount + 1);
        }

        // Return minimum distance starting from the first robot
        return current[0];
    }
}