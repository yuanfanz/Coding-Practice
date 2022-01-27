class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean row = false;
        boolean col = false;
        int[] rowNums = new int[m];
        for (int i = 0; i < m; ++i) {
            rowNums[i] = matrix[i][0];
        }
        int rowRightBound = findRightBound(rowNums, target);
        row = helper(rowRightBound, matrix, target, true);
        if (row) return true;
        int[] colNums = new int[n];
        for (int i = 0; i < n; ++i) {
            colNums[i] = matrix[0][i];
        }
        int colRightBound = findRightBound(colNums, target);
        col = helper(colRightBound, matrix, target, false);
        return col;
    }
    private boolean helper(int bound, int[][] matrix, int target, boolean row) {
        for (int i = 0; i <= bound; ++i) {
            if (row) {
                int[] nums = matrix[i];
                if (search(nums, target)) {
                    return true;
                }
            } else {
                int[] nums = new int[matrix.length];
                for (int k = 0; k < matrix.length; ++k) {
                    nums[k] = matrix[k][i];
                }
                if (search(nums, target)) {
                    return true;
                }
            }
        }
        return false;
    }
    private int findRightBound(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] == target) {
                i = mid + 1;
            } else if (nums[mid] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        if (j < 0 || nums[j] > target) {
            j = -1;
        }
        return j;
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