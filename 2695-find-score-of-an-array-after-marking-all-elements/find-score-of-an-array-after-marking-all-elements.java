class Solution {
    // TLE
    // public long findScore(int[] nums) {
    //     long score = 0;
    //     while (true) {
    //         int minIndex = findMin(nums);
    //         if (minIndex == -1)
    //             break;
    //         score += nums[minIndex];
    //         nums[minIndex] = -1;
    //         if (minIndex > 0) {
    //             nums[minIndex - 1] = -1;
    //         }
    //         if (minIndex < nums.length - 1) {
    //             nums[minIndex + 1] = -1;
    //         }

    //     }
    //     return score;
    // }

    // private int findMin(int[] nums) {
    //     int min = Integer.MAX_VALUE;
    //     int minIndex = -1;
    //     int seen = Integer.MAX_VALUE;
    //     for (int i = 0; i < nums.length; i++) {
    //         int num = nums[i];
    //         if (num != -1)
    //             min = Math.min(min, num);
    //         if (min == num && seen != num) {
    //             minIndex = i;
    //             seen = num;
    //         }
    //     }
    //     return minIndex;
    // }

    public long findScore(int[] nums) {
        long score = 0;
        int n = nums.length;

        // Min-heap to store {value, index} pairs
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0])
                return a[1] - b[1]; // Compare by index if values are equal
            return a[0] - b[0]; // Otherwise, compare by value
        });
        // Fill the heap with elements
        for (int i = 0; i < n; i++) {
            pq.offer(new int[] { nums[i], i });
        }

        boolean[] marked = new boolean[n];

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int value = current[0];
            int index = current[1];

            // Skip if already marked
            if (marked[index]) {
                continue;
            }

            // Add the value to the score
            score += value;

            // Mark the current index and its neighbors
            marked[index] = true;
            if (index > 0) {
                marked[index - 1] = true;
            }
            if (index < n - 1) {
                marked[index + 1] = true;
            }
        }

        return score;
    }
}