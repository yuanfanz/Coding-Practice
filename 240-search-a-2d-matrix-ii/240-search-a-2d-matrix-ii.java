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
        int[] rowBound = findBound(rowNums, target);
        // print(rowBound);
        row = helper(rowBound, matrix, target, true);
        if (row) return true;
        int[] colNums = new int[n];
        for (int i = 0; i < n; ++i) {
            colNums[i] = matrix[0][i];
        }
        int[] colBound = findBound(colNums, target);
        // print(colBound);
        col = helper(colBound, matrix, target, false);
        return col;
    }
    private boolean helper(int[] bound, int[][] matrix, int target, boolean row) {
        for (int i = 0; i <= bound[bound.length - 1]; ++i) {
            if (row) {
                int[] nums = matrix[i];
                if (search(nums, target)) {
                    return true;
                }
            } else {
                int[] nums = new int[matrix.length];
                    // System.out.println("length: " + matrix.length);
                for (int k = 0; k < matrix.length; ++k) {
                    // System.out.println(i + " ");
                    nums[k] = matrix[k][i];
                }
                if (search(nums, target)) {
                    return true;
                }
            }
        }
        return false;
    }
    private int[] findBound(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        int[] result = new int[2];
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
        result[1] = j;
        result[0] = 0;
        return result;
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
    private void print(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}