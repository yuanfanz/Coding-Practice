class Solution {
    private int INF = 0x3f3f3f3f;
    public int minSteps(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <= n; ++j) {
                dp[i][j] = INF;
            }
        }
        // first is notepad (i), second is clipboard (j)
        dp[1][0] = 0;
        dp[1][1] = 1;
        for (int i = 2; i <= n; ++i) {
            int min = INF;
            for (int j = 0; j <= i; ++j) {
                dp[i][j] = dp[i - j][j] + 1;
                min = Math.min(min, dp[i][j]);
            }
            dp[i][i] = min + 1;
        }
        int res = INF;
        for (int i = 0; i <= n; ++i) {
            res = Math.min(res, dp[n][i]);
        }
        return res;
    }
}