class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] res = new int[m][n];
        int total = m * n;
        k = k % total;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int val = grid[i][j];
                int col = j + k;
                int row = col / n;
                if (col < n) {
                    res[i][col] = val;
                } else {
                    res[(i + row) % m][col % n] = val;
                }
            }
        }
        
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; ++j) {
                list.add(res[i][j]);
            }
            result.add(list);
        }
        return result;
    }
}