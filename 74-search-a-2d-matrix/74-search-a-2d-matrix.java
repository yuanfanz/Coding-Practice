class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = matrix.length - 1;
        
        while (i <= j) {
            int mid = i + (j - i) / 2;
            
            if (matrix[mid][0] <= target && target <= matrix[mid][matrix[0].length - 1]) {
                return search(matrix[mid], target);
            } else if (matrix[mid][0] > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return false;
    }
    private boolean search(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
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