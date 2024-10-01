class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] remainderCount = new int[k];

        for (int num : arr) {
            int remainder = (num % k + k) % k;
            remainderCount[remainder]++;
        }

        for (int i = 1; i < k; i++) {
            if (remainderCount[i] != remainderCount[k - i]) {
                return false;
            }
        }

        // Special case: remainder 0 must have an even count to form pairs
        return remainderCount[0] % 2 == 0;
    }
}