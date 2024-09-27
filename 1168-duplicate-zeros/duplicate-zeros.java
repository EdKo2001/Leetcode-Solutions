class Solution {
    public void duplicateZeros(int[] arr) {
        int zeros = 0;
        int n = arr.length;

        // Count the number of zeros
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                zeros++;
            }
        }

        // Traverse the array backwards and shift elements accordingly
        for (int i = n - 1, j = n + zeros - 1; i >= 0; i--, j--) {
            if (j < n) {
                arr[j] = arr[i];
            }
            if (arr[i] == 0 && --j < n) {
                arr[j] = 0;
            }
        }
    }
}
