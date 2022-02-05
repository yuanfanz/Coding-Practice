class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int left = 0;
        int right = nums.length - 1;
        int[] result = new int[nums.length];
        int i = 0;
        int j = nums.length - 1;
        while (i < nums.length && j >= 0) {
            if (nums[i] < pivot) {
                result[left++] = nums[i];
            }
            if (nums[j] > pivot) {
                result[right--] = nums[j];
            }
            i++;
            j--;
        }
        while (left <= right) {
            result[left++] = pivot;
        }
        return result;
    }
}