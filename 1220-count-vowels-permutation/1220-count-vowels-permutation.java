class Solution {
    public int countVowelPermutation(int n) {
        long[][] dp = new long[n + 1][5];
        int mod = (int)Math.pow(10, 9) + 7;
        for (int i = 0; i < 5; ++i) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; ++i) {
            // a 
            dp[i][0] = (dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][4]) % mod;
            // dp[i][0] %= mod;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % mod;
            // dp[i][1] %= mod;
            dp[i][2] = (dp[i - 1][1] + dp[i - 1][3]) % mod;
            // dp[i][2] %= mod;
            dp[i][3] = dp[i - 1][2] % mod;
            // dp[i][3] %= mod;
            dp[i][4] = (dp[i - 1][2] + dp[i - 1][3]) % mod;
        }
        long res = 0;
        for (int i = 0; i < 5; ++i) {
            res += dp[n][i];
            res %= mod;
        }
        return (int)res;
    }
}