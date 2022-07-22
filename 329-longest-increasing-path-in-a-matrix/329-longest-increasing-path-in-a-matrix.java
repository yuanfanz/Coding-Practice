class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        int[][] memo = new int[m][n];
        for (int[] cur : memo) {
            Arrays.fill(cur, -1);
        }
        
        int max = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                // pick every cell as a start point
                max = Math.max(dfs(i, j, memo, matrix, dirs), max);
            }
        }
        return max;
    }
    
    private int dfs(int i, int j, int[][] memo, int[][] matrix, int[][] dirs) {
        if (memo[i][j] != -1) return memo[i][j];
        int m = matrix.length;
        int n = matrix[0].length;
        
        int result = 1;
        for (int[] dir : dirs) {
            int row = i + dir[0];
            int col = j + dir[1];
            if (!checkBoundry(row, col, m, n)) continue;
            if (matrix[row][col] > matrix[i][j]) {
                result = Math.max(result, 1 + dfs(row, col, memo, matrix, dirs));
            }
        }
        // if (result >= memo[i][j]) {
            memo[i][j] = result;
        // }
        return result;
    }
    
    private boolean checkBoundry(int row, int col, int m, int n) {
        if (row < 0 || col < 0 || row >= m || col >= n) {
            return false;
        }
        return true;
    }
}