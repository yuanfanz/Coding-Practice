class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[][] presum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; ++i) {
            presum[i][0] = presum[i - 1][0] + matrix[i - 1][0];
        }
        for (int i = 1; i <= n; ++i) {
            presum[0][i] = presum[0][i - 1] + matrix[0][i - 1];
        }
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                presum[i][j] = matrix[i - 1][j - 1] + presum[i][j - 1] 
                    + presum[i - 1][j] - presum[i - 1][j - 1];
            }
        }
        int count = 0;
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                for (int p = 1; p <= i; ++p) {
                    for (int q = 1; q <= j; ++q) {
                        if (presum[i][j] - presum[p - 1][j]
                            - presum[i][q - 1] + presum[p - 1][q - 1] == target) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}