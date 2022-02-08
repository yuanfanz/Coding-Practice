class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] result = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] < pivot) {
                result[left++] = nums[i];
            }
        }
        for (int i = nums.length - 1; i >= 0; --i) {
            if (nums[i] > pivot) {
                result[right--] = nums[i];
            }
        }
        for (int i = left; i <= right; ++i) {
            result[i] = pivot;
        }
        return result;
    }
}