class Solution {
    public int maximumSum(int[] nums) {
        // Map to store the maximum two values for each sum of digits
        Map<Integer, int[]> map = new HashMap<>();

        int maxSum = -1;

        for (int num : nums) {
            int digitSum = sumOfDigits(num);

            if (!map.containsKey(digitSum)) {
                map.put(digitSum, new int[] { num, -1 });
            } else {
                int[] largestTwo = map.get(digitSum);
                if (num > largestTwo[0]) {
                    largestTwo[1] = largestTwo[0];
                    largestTwo[0] = num;
                } else if (num > largestTwo[1]) {
                    largestTwo[1] = num;
                }
            }
        }

        for (int[] largestTwo : map.values()) {
            if (largestTwo[1] != -1) {
                maxSum = Math.max(maxSum, largestTwo[0] + largestTwo[1]);
            }
        }

        return maxSum;
    }

    private int sumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
