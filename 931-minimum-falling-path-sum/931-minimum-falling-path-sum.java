class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        for (int i = 1; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int min = matrix[i - 1][j];
                if (j > 0) {
                    min = Math.min(min, matrix[i - 1][j - 1]);
                }
                if (j < n - 1) {
                    min = Math.min(min, matrix[i - 1][j + 1]);
                }
                matrix[i][j] += min;
            }
        }
        int min = matrix[m - 1][0];
        for (int j = 1; j < n; ++j) {
            min = Math.min(min, matrix[m - 1][j]);
        }
        return min;
    }
}