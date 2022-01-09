class Solution {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        
        int xor1 = 0;
        int xor2 = 0;
        for (int i = 0; i < n; ++i) {
            xor1 = 0;
            xor2 = 0;
            for (int j = 0; j < n; ++j) {
                xor1 = xor1 ^ (matrix[i][j] ^ (j + 1));
                xor2 = xor2 ^ (matrix[j][i] ^ (j + 1));
            }
            if (xor1 != 0 || xor2 != 0) {
                return false;
            }
        }
        return true;
    }
}