class Solution {
    public int knightDialer(int n) {
        int mod = (int) Math.pow(10, 9) + 7;
        long[][] dp = new long[n + 1][10];
        
        for (int i = 0; i <= 9; ++i){
            dp[1][i] = 1;
        }
        // Map<Integer, List<Integer>> map = new HashMap<>();
        // map.put(0, Arrays.asList(4, 6));
        // map.put(1, Arrays.asList(6, 8));
        // map.put(2, Arrays.asList(7, 9));
        // map.put(3, Arrays.asList(4, 6));
        // map.put(4, Arrays.asList(4, 6));
        // map.put(5, Arrays.asList(4, 6));
        // map.put(6, Arrays.asList(4, 6));
        // map.put(7, Arrays.asList(4, 6));
        // map.put(8, Arrays.asList(4, 6));
        // map.put(9, Arrays.asList(4, 6));
        
        // 4, 5, 6
        for (int i = 2; i <= n; ++i) {
            dp[i][0] = dp[i - 1][4] + dp[i - 1][6];
            dp[i][0] %= mod;
            dp[i][1] = dp[i - 1][6] + dp[i - 1][8];
            dp[i][1] %= mod;
            dp[i][2] = dp[i - 1][7] + dp[i - 1][9];
            dp[i][2] %= mod;
            dp[i][3] = dp[i - 1][4] + dp[i - 1][8];
            dp[i][3] %= mod;
            dp[i][4] = dp[i - 1][3] + dp[i - 1][9] + dp[i - 1][0];
            dp[i][4] %= mod;
            dp[i][6] = dp[i - 1][1] + dp[i - 1][7] + dp[i - 1][0];
            dp[i][6] %= mod;
            dp[i][7] = dp[i - 1][2] + dp[i - 1][6];
            dp[i][7] %= mod;
            dp[i][8] = dp[i - 1][1] + dp[i - 1][3];
            dp[i][8] %= mod;
            dp[i][9] = dp[i - 1][2] + dp[i - 1][4];
            dp[i][9] %= mod;
        }
        int res = 0;
        for (int i = 0; i <= 9; ++i){
            res += dp[n][i];
            res %= mod;
        }
        return res;
    }
}