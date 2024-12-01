class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int ans = 0;

        Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1]));

        for (int[] box : boxTypes) {
            int boxCount = Math.min(truckSize, box[0]);
            ans += boxCount * box[1];
            truckSize -= boxCount;

            if (truckSize == 0)
                break;
        }

        return ans;
    }
}