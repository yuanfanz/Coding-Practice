class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int top = 0;
        int down = m - 1;
        int left = 0;
        int right = n - 1;
        List<Integer> result = new ArrayList<>();
        while (result.size() < m * n) {
            for (int j = left; j <= right && result.size() < m * n; ++j) {
                result.add(matrix[top][j]);
            }
            for (int i = top + 1; i <= down - 1 && result.size() < m * n; ++i) {
                result.add(matrix[i][right]);
            }
            for (int j = right; j >= left && result.size() < m * n; --j) {
                result.add(matrix[down][j]);
            }
            for (int i = down - 1; i >= top + 1 && result.size() < m * n; --i) {
                result.add(matrix[i][left]);
            }
            top++;
            down--;
            left++;
            right--;
        }
        return result;
    }
}