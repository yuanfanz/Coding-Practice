class Solution {
    public int countHousePlacements(int n) {
        if (n == 1) return 4;
        if (n == 2) return 9;
        
        int mod = (int) Math.pow(10, 9) + 7;
        long[] dp = new long[n + 1];
        dp[1] = 2;
        dp[2] = 3;
        
        for (int i = 3; i <= n; ++i) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
        }
        long res = (dp[n] * dp[n]) % mod;
        return (int) res;
    }
}