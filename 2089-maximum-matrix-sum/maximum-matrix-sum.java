class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long totalSum = 0;
        int minAbs = Integer.MAX_VALUE;
        int negativeCount = 0;

        for (int[] row : matrix) {
            for (int element : row) {
                totalSum += Math.abs(element);
                if (element < 0)
                    negativeCount++;
                minAbs = Math.min(minAbs, Math.abs(element));
            }
        }

        if ((negativeCount & 1) == 1) {
            return totalSum - 2 * minAbs; // One value remains negative

        }

        return totalSum; // All values can be made positive
    }

}