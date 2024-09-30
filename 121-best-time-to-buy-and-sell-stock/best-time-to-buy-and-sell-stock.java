class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int start = 0;

        for (int end = 1; end < prices.length; end++) {
            if (prices[start] < prices[end]) {
                maxProfit = Math.max(maxProfit, prices[end] - prices[start]);
            } else {
                start = end;
            }
        }

        return maxProfit;
    }
}