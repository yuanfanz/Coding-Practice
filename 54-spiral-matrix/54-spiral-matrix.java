class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        
        int m = matrix.length;
        int n = matrix[0].length;
        int up = 0;
        int down = m - 1;
        int left = 0;
        int right = n - 1;
        while (result.size() < m * n) {
            for (int i = left; i <= right && result.size() < m * n; ++i) {
                result.add(matrix[up][i]);
            }
            for (int i = up + 1; i <= down - 1 && result.size() < m * n; ++i) {
                result.add(matrix[i][right]);
            }
            for (int i = right; i >= left && result.size() < m * n; --i) {
                result.add(matrix[down][i]);
            }
            for (int i = down - 1; i >= up + 1 && result.size() < m * n; --i) {
                result.add(matrix[i][left]);
            }
            up++;
            down--;
            left++;
            right--;
        }
        return result;
    }
}