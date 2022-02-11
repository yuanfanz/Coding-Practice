class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        
        int total = m + n - 2;
        boolean right = true;
        int[] result = new int[m * n];
        int index = 0;
        for (int i = 0; i <= total; ++i) {
            for (int j = 0; j <= i; ++j) {
                int row = j;
                int col = i - j;
                // if (row >= m || col >= n) continue;
                if (right) {
                    int tmp = row;
                    row = col;
                    col = tmp;
                }
                if (row < m && col < n) {
                    result[index++] = mat[row][col];
                }
            }
            right = !right;
        }
        return result;
    }
}