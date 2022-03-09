class Solution {
    public int countOrders(int n) {
        int mod = (int) Math.pow(10, 9) + 7;
        long[] dp = new long[n + 2];
        dp[1] = 1L;
        dp[2] = 6L;
        for (int i = 3; i <= n; ++i) {
            int spaces = i * 2 - 1;
            int combinations = spaces * (1 + spaces) / 2;
            dp[i] = (dp[i - 1] * combinations) % mod;
        }
        return (int) dp[n];
    }
}