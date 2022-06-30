class Solution {
    public int minMoves2(int[] nums) {
        int[] arr = sortArray(nums);
        
        int i = 0;
        int j = nums.length - 1;
        int res = 0;
        while (i < j) {
            res += (nums[j] - nums[i]);
            i++;
            j--;
        }
        return res;
    }
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