class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int count = 0;
        int left = 0;
        int oddCount = 0;
        int validStart = 0;

        for (int right = 0; right < nums.length; right++) {
            if ((nums[right] & 1) != 0) {
                oddCount++;
            }

            if (oddCount == k) {
                validStart = 0;

                while (oddCount == k) {
                    if ((nums[left] & 1) != 0) {
                        oddCount--;
                    }
                    left++;
                    validStart++;
                }
            }

            count += validStart;
        }

        return count;
    }
}
