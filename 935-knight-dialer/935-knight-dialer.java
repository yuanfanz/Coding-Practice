class Solution {
    public int knightDialer(int n) {
        int mod = (int) Math.pow(10, 9) + 7;
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(0, Arrays.asList(4, 6));
        map.put(1, Arrays.asList(6, 8));
        map.put(2, Arrays.asList(7, 9));
        map.put(3, Arrays.asList(4, 8));
        map.put(4, Arrays.asList(3, 9, 0));
        map.put(5, new ArrayList<>());
        map.put(6, Arrays.asList(1, 7, 0));
        map.put(7, Arrays.asList(2, 6));
        map.put(8, Arrays.asList(1, 3));
        map.put(9, Arrays.asList(2, 4));
        
        long[][] dp = new long[n + 1][10];
        for (int i = 0; i <= 9; ++i){
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; ++i) {
            for (int j = 0; j <= 9; ++j){
                for (int prev : map.get(j)) {
                    dp[i][j] += dp[i - 1][prev];
                    dp[i][j] %= mod;
                }
            }
        }
        int res = 0;
        for (int i = 0; i <= 9; ++i){
            res += dp[n][i];
            res %= mod;
        }
        return res;
    }
}