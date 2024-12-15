class Solution {
    public boolean confusingNumber(int n) {
        Map<Integer, Integer> rotationMap = Map.of(
                0, 0, 1, 1, 6, 9, 8, 8, 9, 6);
        Set<Integer> invalidNumbers = Set.of(2, 3, 4, 5, 7);

        int original = n;
        int rotated = 0;

        while (n > 0) {
            int digit = n % 10;

            if (invalidNumbers.contains(digit)) {
                return false;
            }

            rotated = rotated * 10 + rotationMap.get(digit);
            n /= 10;
        }

        return rotated != original;
    }
}