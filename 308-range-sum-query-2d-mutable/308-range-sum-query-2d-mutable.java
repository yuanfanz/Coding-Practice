class NumMatrix {
    int[][] arr;
    int[][] fenwickTree;
    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        arr = new int[m][n];
        fenwickTree = new int[m + 1][n + 1];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                update(i, j, matrix[i][j]);
            }
        }
    }
    
    public void update(int row, int col, int val) {
        int diff = val - arr[row][col];
        arr[row][col] = val;
        for (int i = row + 1; i < fenwickTree.length; i += (i & -i)) {
            for (int j = col + 1; j < fenwickTree[0].length; j += (j & -j)) {
                fenwickTree[i][j] += diff;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return getSum(row2 + 1, col2 + 1) + getSum(row1, col1)
            - getSum(row2 + 1, col1) - getSum(row1, col2 + 1);
    }
    
    private int getSum(int row, int col) {
        int sum = 0;
        for (int i = row; i > 0; i -= (i & -i)) {
            for (int j = col; j > 0; j -= (j & -j)) {
                sum += fenwickTree[i][j];
            }
        }
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */