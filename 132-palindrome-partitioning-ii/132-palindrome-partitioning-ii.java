class Solution {
    public int minCut(String s) {
        int n = s.length();
        
        int[] dp = new int[n];
        boolean[][] isPalin = new boolean[n][n];
        
        for (int i = 0; i < n; ++i) {
            dp[i] = i;
            for (int j = 0; j <= i; ++j) {
                if (s.charAt(i) == s.charAt(j) && (j + 1 > i - 1 || isPalin[j + 1][i - 1])) {
                    isPalin[i][j] = isPalin[j][i] = true;
                    if (j == 0) {
                        dp[i] = 0;
                    } else {
                        dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                    }
                }
            }
        }
        return dp[n - 1];
    }
}