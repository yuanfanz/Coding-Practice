class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = matrix.length - 1;
        
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (matrix[mid][0] == target) {
                i = mid + 1;
            } else if (matrix[mid][0] > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        if (j < 0 || matrix[j][0] > target) {
            System.out.println(j);
            return false;
        }
        int row = j;
        i = 0;
        j = matrix[0].length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return false;
    }
}