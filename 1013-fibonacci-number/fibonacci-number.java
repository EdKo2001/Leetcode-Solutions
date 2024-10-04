class Solution {
    int[] cache = new int[10001];

    public int fib(int n) {
        if (n < 2)
            return n;

        if (cache[n] != 0)
            return cache[n];

        cache[n] = fib(n - 1) + fib(n - 2);

        return cache[n];
    }
}
