class Solution {
    public int maximumWealth(int[][] accounts) {
        int maxWealth = 0;

        for (int[] acc : accounts) {
            int sum = 0;
            for (int number : acc) {
                sum += number;
            }
            maxWealth = Math.max(maxWealth, sum);
        }

        return maxWealth;
    }
}