class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;
        
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                dp[i][j] = mat[i - 1][j - 1] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
            }
        }
        
        int i = 0;
        int j = Math.min(m, n);
        while (i < j) {
            int mid = i + (j - i + 1) / 2;
            if (isValid(mid, threshold, m, n, dp)) {
                i = mid;
            } else {
                j = mid - 1;
            }
        }
        return i;
    }
    
    private boolean isValid(int mid, int threshold, int m, int n, int[][] dp) {
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (i < mid || j < mid) {
                    continue;
                }
                if (dp[i][j] - dp[i - mid][j] - dp[i][j - mid] + dp[i - mid][j - mid] <= threshold) {
                    return true;
                }
            }
        }
        return false;
    }
}