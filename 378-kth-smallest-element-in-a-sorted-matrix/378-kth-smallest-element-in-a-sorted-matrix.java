class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[] arr = new int[m * n];
        int index = 0;
        for (int[] cur : matrix) {
            for (int i : cur) {
                arr[index++] = i;
            }
        }
        // print(arr);
        int i = 0;
        int j = arr.length - 1;
        while (i <= j) {
            int pivot = partition(arr, i, j);
            if (pivot == k - 1) {
                return arr[pivot];
            } else if (pivot < k) {
                i = pivot + 1;
            } else {
                j = pivot - 1;
            }
        }
        return -1;
    }
    private int partition(int[] nums, int i, int j) {
        int pivot = nums[i];
        while (i < j) {
            while (i < j && nums[j] >= pivot) {
                j--;
            }
            nums[i] = nums[j];
            while (i < j && nums[i] <= pivot) {
                i++;
            }
            nums[j] = nums[i];
        }
        nums[i] = pivot;
        return i;
    }
    private void print(int[] grid) {
        for (int i = 0; i < grid.length; ++i) {
            System.out.print(grid[i] + " ");
        }
        System.out.println();
    }
}