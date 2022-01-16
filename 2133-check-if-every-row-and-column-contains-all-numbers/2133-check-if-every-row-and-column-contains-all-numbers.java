class Solution {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        int row = 0;
        int col = 0;
        
        for (int i = 0; i < n; ++i) {
            row = 0;
            col = 0;
            for (int j = 0; j < n; ++j) {
                row = row ^ matrix[i][j] ^ (j + 1);
                col = col ^ matrix[j][i] ^ (j + 1);
            }
            if (row != 0 || col != 0) {
                return false;
            }
        }
        return true;
    }
}