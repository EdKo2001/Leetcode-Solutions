class Solution {
    public int maximumPrimeDifference(int[] nums) {
        int maxDistance = Integer.MIN_VALUE;
        int firstPrimeIdx = -1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (!isPrime(num))
                continue;
            if (firstPrimeIdx == -1) {
                firstPrimeIdx = i;
                maxDistance = 0;
            } else {
                maxDistance = i - firstPrimeIdx;
            }
        }
        return maxDistance;
    }

    private static boolean isPrime(int num) {
        if (num <= 1)
            return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}