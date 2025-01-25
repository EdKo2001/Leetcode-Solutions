import java.util.Arrays;

class Solution {
    private static final int MOD = 1000000007;

    public int minMaxSums(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;

        long[] fact = new long[n + 1];
        long[] invFact = new long[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }
        invFact[n] = pow(fact[n], MOD - 2, MOD);
        for (int i = n - 1; i >= 0; i--) {
            invFact[i] = invFact[i + 1] * (i + 1) % MOD;
        }

        long total = 0;
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            int elementsBefore = i;
            int tMax = Math.min(k - 1, elementsBefore);
            long sumMax = 0;
            for (int s = 0; s <= tMax; s++) {
                sumMax = (sumMax + combination(fact, invFact, elementsBefore, s)) % MOD;
            }

            int elementsAfter = (n - 1) - i;
            int tMin = Math.min(k - 1, elementsAfter);
            long sumMin = 0;
            for (int s = 0; s <= tMin; s++) {
                sumMin = (sumMin + combination(fact, invFact, elementsAfter, s)) % MOD;
            }

            long contribution = (sumMax + sumMin) % MOD;
            contribution = x * contribution % MOD;
            total = (total + contribution) % MOD;
        }

        return (int) (total % MOD);
    }

    private long combination(long[] fact, long[] invFact, int n, int s) {
        if (s < 0 || s > n) {
            return 0;
        }
        return fact[n] * invFact[s] % MOD * invFact[n - s] % MOD;
    }

    private long pow(long a, int b, int mod) {
        long res = 1;
        a %= mod;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = res * a % mod;
            }
            a = a * a % mod;
            b >>= 1;
        }
        return res;
    }
}