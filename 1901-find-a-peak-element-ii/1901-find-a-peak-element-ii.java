class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int i = 0;
        int j = mat.length - 1;
        while (i < j) {
            int mid = i + (j - i) / 2;
            
            int col1 = getMax(mat, mid - 1);
            int col2 = getMax(mat, mid);
            int col3 = getMax(mat, mid + 1);
            
            int value1 = mid - 1 >= 0 ? mat[mid - 1][col1] : -1;
            int value2 = mat[mid][col2];
            int value3 = mid + 1 < mat.length ? mat[mid + 1][col3] : -1;
            if (value2 > value3 && value2 > value1) {
                return new int[]{mid, col2};
            }
            if (value1 > value3) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return new int[]{i, getMax(mat, i)};
    }
    
    private int getMax(int[][] mat, int row) {
        if (row < 0 || row >= mat.length) {
            return -1;
        }
        int col = 0;
        int max = mat[row][0];
        for (int i = 1; i < mat[row].length; ++i) {
            if (mat[row][i] >= max) {
                col = i;
                max = mat[row][i];
            }
        }
        return col;
    }
}