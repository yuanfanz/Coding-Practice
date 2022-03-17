class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        for (int i = 0; i < 4; ++i) {
            rotate(mat);
            if (equals(mat, target)) return true;
        }
        return false;
    }
    
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int i = 0;
        int j = m - 1;
        while (i < j) {
            int[] tmp = matrix[i];
            matrix[i] = matrix[j];
            matrix[j] = tmp;
            i++;
            j--;
        }
        for (i = 0; i < m; ++i) {
            for (j = i + 1; j < n; ++j) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
    
    public boolean equals(int[][] mat1, int[][] mat2) {
        for (int i = 0; i < mat1.length; ++i) {
            for (int j = 0; j < mat1[0].length; ++j) {
                if (mat1[i][j] != mat2[i][j]) return false;
            }
        }
        return true;
    }
}