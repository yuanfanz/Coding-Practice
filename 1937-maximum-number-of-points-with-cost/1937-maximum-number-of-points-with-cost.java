class Solution {
    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        
        long[][] dp = new long[m][n];
        int index = 0;
        for (int i : points[0]) {
            dp[0][index++] = (long) i;
        }
        for (int i = 0; i < m - 1; ++i) {
            long[] left = new long[n];
            left[0] = dp[i][0];
            for (int j = 1; j < n; ++j) {
                left[j] = Math.max(left[j - 1] - 1, dp[i][j]);
            }
            long[] right = new long[n];
            right[n - 1] = dp[i][n - 1];
            for (int j = n - 2; j >= 0; --j) {
                right[j] = Math.max(right[j + 1] - 1, dp[i][j]);
            }
            for (int j = 0; j < n; ++j) {
                dp[i + 1][j] = points[i + 1][j] + Math.max(left[j], right[j]);
            }
        }
        long res = 0;
        for (long i : dp[m - 1]) {
            res = Math.max(res, i);
        }
        return res;
    }
}