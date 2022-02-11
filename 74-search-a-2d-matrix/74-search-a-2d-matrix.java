class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int i = 0;
        int j = m - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (matrix[mid][0] > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        if (j < 0 || matrix[j][0] > target) {
            return false;
        }
        int index = j;
        i = 0;
        j = n - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (matrix[index][mid] == target) {
                return true;
            } else if (matrix[index][mid] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return false;
    }
}