class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int i = 0;
        int j = m - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (matrix[mid][0] <= target && target <= matrix[mid][n - 1]) {
                return search(matrix[mid], 0, n - 1, target);
            } else if (matrix[mid][0] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return false;
    }
    private boolean search(int[] nums, int i, int j, int target) {
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return false;
    }
}