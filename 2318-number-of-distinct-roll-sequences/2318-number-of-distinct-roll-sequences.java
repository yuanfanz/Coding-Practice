class Solution {
    public int distinctSequences(int n) {
        if (n == 1) return 6;
        int mod = (int) Math.pow(10, 9) + 7;
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(1, Arrays.asList(2, 3, 4, 5, 6));
        map.put(2, Arrays.asList(1, 3, 5));
        map.put(3, Arrays.asList(1, 2, 4, 5));
        map.put(4, Arrays.asList(1, 3, 5));
        map.put(5, Arrays.asList(1, 2, 3, 4, 6));
        map.put(6, Arrays.asList(1, 5));
        
        int[][][] dp = new int[n + 1][7][7];
        
        for (int i = 1; i <= 6; ++i) {
            dp[1][0][i] = 1;
        }
        for (int i = 1; i <= 6; ++i) {
            for (int j : map.get(i)) {
                dp[2][i][j] += dp[1][0][j];
            }
        }
        //  .. _c _b _a ..
        for (int i = 3; i <= n; ++i) {
            for (int a = 1; a <= 6; ++a) {
                for (int b : map.get(a)) {
                    for (int c = 1; c <= 6; ++c) {
                        if (c != a) {
                            dp[i][b][a] += dp[i - 1][c][b];
                            dp[i][b][a] %= mod;
                        }
                    }
                }
            }
        }
        int res = 0;
        for (int i = 1; i <= 6; ++i) {
            for (int j = 1; j <= 6; ++j) {
                if (i == j) continue;
                res += dp[n][i][j];
                res %= mod;
            }
        }
        return res;
    }
}