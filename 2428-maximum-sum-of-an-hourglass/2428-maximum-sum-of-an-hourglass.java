class Solution {
    public int maxSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < m - 1; ++i) {
            for (int j = 1; j < n - 1; ++j) {
                int sum = grid[i][j];
                // if (i - 1 >= 0) {
                    sum += grid[i - 1][j - 1];
                    sum += grid[i - 1][j];
                    sum += grid[i - 1][j + 1];
                // }
                sum += grid[i + 1][j - 1];
                sum += grid[i + 1][j];
                sum += grid[i + 1][j + 1];
                
                max = Math.max(max, sum);
            }
        }
        return max;
    }
}