class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        
        int[] result = new int[m * n];
        boolean flag = true;
        int index = 0;
        int total = m + n - 2;
        for (int cur = 0; cur <= total; ++cur) {
            for (int i = 0; i <= cur; ++i) {
                int j = cur - i;
                int row = i;
                int col = j;
                if (flag) {
                    int tmp = row;
                    row = col;
                    col = tmp;
                }
                if (row < m && col < n) {
                    result[index++] = mat[row][col];
                }
            }
            flag = !flag;
        }
        return result;
    }
}