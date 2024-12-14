class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            if (binarySearch(matrix, i, target, 0, matrix[i].length - 1))
                return true;
        }

        return false;
    }

    private boolean binarySearch(int[][] matrix, int row, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[row][mid] == target)
                return true;
            else if (matrix[row][mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }

        return false;
    }
}