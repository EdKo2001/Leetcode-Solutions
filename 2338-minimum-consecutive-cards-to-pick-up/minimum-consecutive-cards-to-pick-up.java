class Solution {
    public int minimumCardPickup(int[] cards) {
        HashMap<Integer, Integer> lastOccur = new HashMap<>();
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < cards.length; i++) {
            int card = cards[i];

            if (lastOccur.containsKey(card)) {
                min = Math.min(min, i - lastOccur.get(card) + 1);
            }

            lastOccur.put(card, i);
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}