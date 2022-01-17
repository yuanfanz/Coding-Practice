class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        
        int left = 0;
        int right = n - 1;
        int up = 0;
        int down = m - 1;
        while (result.size() < m * n) {
            for (int j = left; j <= right && result.size() < m * n; ++j) {
                result.add(matrix[up][j]);
            }
            for (int i = up + 1; i <= down - 1 && result.size() < m * n; ++i) {
                result.add(matrix[i][right]);
            }
            for (int j = right; j >= left && result.size() < m * n; --j) {
                result.add(matrix[down][j]);
            }
            for (int i = down - 1; i >= up + 1 && result.size() < m * n; --i) {
                result.add(matrix[i][left]);
            }
            left++;
            right--;
            up++;
            down--;
        }
        return result;
    }
}