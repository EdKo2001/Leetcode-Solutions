class Solution {
    public int[][] minScore(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Create a list to store the values of the matrix and their indices.
        List<int[]> nums = new ArrayList<>();

        // Create arrays to store the minimum values for every row and column.
        int[] rowMax = new int[rows];
        int[] colMax = new int[cols];
        Arrays.fill(rowMax, 1);
        Arrays.fill(colMax, 1);

        // Populate the nums list with grid values and their positions.
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                nums.add(new int[] { grid[i][j], i, j });
            }
        }

        // Sort nums by the grid values in ascending order.
        nums.sort((a, b) -> Integer.compare(a[0], b[0]));

        // Assign ranks to each cell based on the sorting.
        for (int[] num : nums) {
            int value = num[0];
            int x = num[1];
            int y = num[2];

            // Determine the new value as the max of the current row and column.
            int newValue = Math.max(rowMax[x], colMax[y]);
            grid[x][y] = newValue;

            // Update rowMax and colMax for the next values.
            rowMax[x] = newValue + 1;
            colMax[y] = newValue + 1;
        }

        return grid;
    }
}