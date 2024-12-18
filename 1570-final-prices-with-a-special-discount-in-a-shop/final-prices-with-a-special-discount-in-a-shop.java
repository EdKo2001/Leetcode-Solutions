class Solution {
    public int[] finalPrices(int[] prices) {
        Deque<Integer> stack = new LinkedList<>();

        for (int i = prices.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() > prices[i]) {
                stack.pop();
            }

            int discount = stack.isEmpty() ? 0 : stack.peek();
            prices[i] -= discount;

            stack.push(prices[i] + discount);
        }

        return prices;
    }
}
