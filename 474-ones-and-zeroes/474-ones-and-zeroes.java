class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        
        int[][][] dp = new int[len + 1][m + 1][n + 1];
        
        for (int i = 1; i <= len; ++i) {
            int[] count = countZeroAndOne(strs[i - 1]);
            for (int j = 0; j <= m; ++j) {
                for (int k = 0; k <= n; ++k) {
                    dp[i][j][k] = dp[i - 1][j][k];
                    if (j >= count[0] && k >= count[1]) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j - count[0]][k - count[1]] + 1);
                    }
                }
            }
        }
        return dp[len][m][n];
    }
    
    private int[] countZeroAndOne(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '0') {
                count++;
            }
        }
        return new int[]{count, s.length() - count};
    }
}