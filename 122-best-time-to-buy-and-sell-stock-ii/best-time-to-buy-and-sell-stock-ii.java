class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int start = 0;

        for (int end = 1; end < prices.length; end++) {
            if (prices[start] < prices[end]) {
                maxProfit += prices[end] - prices[start];
            }
            start = end;
        }

        return maxProfit;
    }
}