class Solution {
    public int coinChange(int[] coins, int amount) {
        // DP array to store the minimum number of coins for each amount
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1); // Initialize all values to a large number
        dp[0] = 0; // Base case: 0 coins are needed to make amount 0

        // Iterate over all amounts from 1 to the target amount
        for (int i = 1; i <= amount; i++) {
            // Check each coin denomination
            for (int coin : coins) {
                // If the current coin can be used (i.e., it's <= the current amount)
                if (coin <= i) {
                    // Update the DP array with the minimum number of coins
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        // If the amount cannot be formed with any combination of coins, return -1
        return dp[amount] > amount ? -1 : dp[amount];
    }
}