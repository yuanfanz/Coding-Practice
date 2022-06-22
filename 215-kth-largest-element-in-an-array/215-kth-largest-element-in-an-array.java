class Solution {
    public int findKthLargest(int[] nums, int k) {
        int i = 0;
        int j = nums.length - 1;
        int index = nums.length - k;
        
        while (i < j) {
            int pivot = partition(nums, i, j);
            if (pivot == index) {
                break;
            } else if (pivot < index) {
                i = pivot + 1;
            } else {
                j = pivot - 1;
            }
        }
        return nums[nums.length - k];
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