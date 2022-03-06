class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        
        if (m * n != r * c || m == r) {
            return mat;
        }
        int[][] res = new int[r][c];
        for (int i = 0; i < r * c; ++i) {
            res[i / c][i % c] = mat[i / n][i % n];
        }
        return res;
    }
}