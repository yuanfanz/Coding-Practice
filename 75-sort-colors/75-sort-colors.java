class Solution {
    public void sortColors(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        sort(nums, i, j);
    }
    private void sort(int[] nums, int i, int j) {
        if (i >= j) {
            return;
        }
        int pivot = partition(nums, i, j);
        sort(nums, i, pivot);
        sort(nums, pivot + 1, j);
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