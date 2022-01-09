class Solution {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        
        boolean[] set = new boolean[n + 1];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (set[matrix[i][j]]) {
                    return false;
                }
                set[matrix[i][j]] = true;
            }
            set = new boolean[n + 1];
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (set[matrix[j][i]]) {
                    return false;
                }
                set[matrix[j][i]] = true;
            }
            set = new boolean[n + 1];
        }
        return true;
    }
}