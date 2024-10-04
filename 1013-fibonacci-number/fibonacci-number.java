class Solution {
    // Top-Down Dynamic Programming
    // int[] cache = new int[10001];

    // public int fib(int n) {
    // if (n < 2)
    // return n;

    // if (cache[n] != 0)
    // return cache[n];

    // cache[n] = fib(n - 1) + fib(n - 2);

    // return cache[n];
    // }

    // Down-Up Dynamic Programming
    public int fib(int n) {
        if (n == 0 || n == 1)
            return n;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
