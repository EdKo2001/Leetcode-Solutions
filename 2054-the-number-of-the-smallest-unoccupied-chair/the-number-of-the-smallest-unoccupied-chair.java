public class Solution {

    public int smallestChair(int[][] times, int targetFriend) {
        int targetArrival = times[targetFriend][0];
        Arrays.sort(times, (a, b) -> a[0] - b[0]);

        int nextChair = 0;
        PriorityQueue<int[]> leavingQueue = new PriorityQueue<>(
                (a, b) -> a[0] - b[0]);
        TreeSet<Integer> availableChairs = new TreeSet<>();

        for (int[] time : times) {
            int arrival = time[0];
            int leave = time[1];

            // Free up chairs based on current time
            while (!leavingQueue.isEmpty() && leavingQueue.peek()[0] <= arrival) {
                availableChairs.add(leavingQueue.poll()[1]);
            }

            int currentChair;
            // Assign chair from available set or increment new chair
            if (!availableChairs.isEmpty()) {
                currentChair = availableChairs.first();
                availableChairs.remove(currentChair);
            } else {
                currentChair = nextChair++;
            }

            // Push current leave time and chair
            leavingQueue.offer(new int[] { leave, currentChair });

            // Check if it's the target friend
            if (arrival == targetArrival)
                return currentChair;
        }

        return 0;
    }
}