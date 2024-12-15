class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        // Define a max-heap based on the potential gain of adding a student
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(
                gain(b[0], b[1]),
                gain(a[0], a[1])));

        // Add all classes to the heap
        for (int[] cls : classes) {
            maxHeap.offer(cls);
        }

        // Distribute extra students to maximize the average ratio
        while (extraStudents > 0) {
            int[] cls = maxHeap.poll();
            cls[0]++; // Add one student to the class
            cls[1]++;
            maxHeap.offer(cls); // Reinsert the updated class
            extraStudents--;
        }

        // Calculate the final average
        double totalAverage = 0;
        for (int[] cls : classes) {
            totalAverage += (double) cls[0] / cls[1];
        }

        return totalAverage / classes.length;
    }

    // Calculate the gain of adding one student to a class
    private double gain(int pass, int total) {
        return ((double) (pass + 1) / (total + 1)) - ((double) pass / total);
    }
}
