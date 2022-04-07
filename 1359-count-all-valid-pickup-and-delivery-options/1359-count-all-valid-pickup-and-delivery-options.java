class Solution {
    public int countOrders(int n) {
        int mod = 1000000007;
        
        long[] dp = new long[n + 2];
        dp[1] = 1L;
        dp[2] = 6L;
        for (int i = 3; i <= n; ++i) {
            int spacesInBetween = i * 2 - 1;
            int combinations = spacesInBetween * (1 + spacesInBetween) / 2;
            dp[i] = (dp[i - 1] * combinations) % mod;
        }
        return (int) dp[n];
    }
}