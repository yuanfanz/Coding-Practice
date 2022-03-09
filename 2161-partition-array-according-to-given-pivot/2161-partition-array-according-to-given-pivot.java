class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] result = new int[nums.length];
        int start = 0;
        int end = nums.length - 1;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] < pivot) {
                result[start++] = nums[i];
            }
        }
        for (int i = nums.length - 1; i >= 0; --i) {
            if (nums[i] > pivot) {
                result[end--] = nums[i];
            }
        }
        for (int i = start; i <= end; ++i) {
            result[i] = pivot;
        }
        return result;
    }
}