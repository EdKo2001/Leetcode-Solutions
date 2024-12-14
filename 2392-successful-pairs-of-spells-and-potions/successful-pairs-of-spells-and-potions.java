class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] res = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            res[i] = potions.length - binarySearch(spells[i], potions, success);
        }
        return res;
    }

    private int binarySearch(int spell, int[] potions, long success) {
        int left = 0, right = potions.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) potions[mid] * spell >= success) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        // `left` is the first index where the condition is met
        return left;
    }
}