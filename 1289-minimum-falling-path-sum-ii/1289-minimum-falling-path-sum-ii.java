class Solution {
    public int minFallingPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int first = -1;
        int second = -1;
        // deal with first row
        for (int j = 0; j < n; ++j) {
            if (grid[0][j] < (first == -1 ? Integer.MAX_VALUE : grid[0][first])) {
                second = first;
                first = j;
            } else if (grid[0][j] < (second == -1 ? Integer.MAX_VALUE : grid[0][second])) {
                second = j;
            }
        }
        for (int i = 1; i < m; ++i) {
            int newFirst = -1;
            int newSecond = -1;
            for (int j = 0; j < n; ++j) {
                if (first != j) {
                    grid[i][j] += grid[i - 1][first];
                } else {
                    grid[i][j] += grid[i - 1][second];
                }
                if (grid[i][j] < (newFirst == -1 ? Integer.MAX_VALUE : grid[i][newFirst])) {
                    newSecond = newFirst;
                    newFirst = j;
                } else if (grid[i][j] < (newSecond == -1 ? Integer.MAX_VALUE : grid[i][newSecond])) {
                    newSecond = j;
                }
            }
            first = newFirst;
            second = newSecond;
        }
        int res = Integer.MAX_VALUE;
        for (int x : grid[m - 1]) {
            res = Math.min(res, x);
        }
        return res;
    }
}