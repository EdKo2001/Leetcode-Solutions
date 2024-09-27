// class Solution {
//     public void duplicateZeros(int[] arr) {
//         int zeros = 0;
//         int n = arr.length;

//         // Count the number of zeros
//         for (int i = 0; i < n; i++) {
//             if (arr[i] == 0) {
//                 zeros++;
//             }
//         }

//         // Traverse the array backwards and shift elements accordingly
//         for (int i = n - 1, j = n + zeros - 1; i >= 0; i--, j--) {
//             if (j < n) {
//                 arr[j] = arr[i];
//             }
//             if (arr[i] == 0 && --j < n) {
//                 arr[j] = 0;
//             }
//         }
//     }
// }

class Solution {
    public void duplicateZeros(int[] arr) {
       int n = arr.length;
        
        // Traverse the array
        for (int i = 0; i < n; i++) {
            // If a zero is encountered
            if (arr[i] == 0) {
                // Shift elements to the right, starting from the end
                for (int j = n - 1; j > i; j--) {
                    arr[j] = arr[j - 1];
                }
                // Duplicate the zero by setting the next element to zero
                i++;  // Skip over the next position as it contains the duplicated zero
            }
        }
    }
}