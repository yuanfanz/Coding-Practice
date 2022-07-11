class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        if (jobDifficulty.length < d) return -1;
        
        int n = jobDifficulty.length;
        
        int[][] dp = new int[d + 1][n + 1];
        int firstDayJob = jobDifficulty[0];
        for (int j = 1; j <= n; ++j) {
            firstDayJob = Math.max(firstDayJob, jobDifficulty[j - 1]);
            dp[1][j] = firstDayJob;
        }
        // for (int j = 1; j <= n; ++j) {
        //     dp[1][j] = Math.max(dp[1][j - 1], jobDifficulty[j - 1]);
        // }
        for (int i = 2; i <= d; ++i) {
            for (int j = 1; j <= n; ++j) {
                dp[i][j] = Integer.MAX_VALUE;
                int localMax = 0;
                
                for (int k = j; k >= i; --k) {
                    localMax = Math.max(jobDifficulty[k - 1], localMax);
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k - 1] + localMax);
                }
            }
        }
        return dp[d][n];
    }
}