class Solution {
    public int[] sortArray(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        sort(nums, i, j);
        return nums;
    }
    private void sort(int[] nums, int i, int j) {
        if (i >= j) {
            return;
        }
        int pivot = partition(nums, i, j);
        sort(nums, i, pivot);
        sort(nums, pivot + 1, j);
    }
    private int[] merge(int[] left, int[] right) {
        if (left.length == 0) {
            return right;
        }
        if (right.length == 0) {
            return left;
        }
        int[] res = new int[left.length + right.length];
        int index = 0;
        for (int i = 0; i < left.length; ++i) {
            res[index++] = left[i];
        }
        for (int i = 0; i < right.length; ++i) {
            res[index++] = right[i];
        }
        return res;
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
}