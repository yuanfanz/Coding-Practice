class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int total = n * n;
        
        int up = 0;
        int down = n - 1;
        int left = 0;
        int right = n - 1;
        
        int count = 1;
        while (count <= total) {
            for (int i = left; i <= right && count <= total; ++i) {
                res[up][i] = count++;
            }
            for (int i = up + 1; i < down && count <= total; ++i) {
                res[i][right] = count++;
            }
            for (int i = right; i >= left && count <= total; --i) {
                res[down][i] = count++;
            }
            for (int i = down - 1; i > up && count <= total; --i) {
                res[i][left] = count++;
            }
            up++;
            down--;
            left++;
            right--;
        }
        return res;
    }
}