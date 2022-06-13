class Solution {
    public int mctFromLeafValues(int[] arr) {
        int n = arr.length;
        
        // max value from i to j
        int[][] max = new int[n][n];
        for (int j = 0; j < n; ++j) {
            int maxValue = arr[j];
            for (int i = j; i >= 0; --i) {
                maxValue = Math.max(maxValue, arr[i]);
                max[i][j] = maxValue;
            }
        }
        int[][] dp = new int[n][n];
        for (int j = 0; j < n; ++j) {
            for (int i = j; i >= 0; --i) {
                int min = Integer.MAX_VALUE;
                for (int k = i; k + 1 <= j; ++k) {
                    min = Math.min(min, dp[i][k] + dp[k + 1][j] + max[i][k] * max[k + 1][j]);
                    dp[i][j] = min;
                }
            }
        }
        return dp[0][n - 1];
    }
}