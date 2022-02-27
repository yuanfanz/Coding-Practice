class Solution {
    public int[] searchRange(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        int start = -1;
        int end = -1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        start = i;
        if (i > nums.length - 1 || nums[i] != target) {
            start = -1;
        }
        i = 0;
        j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        end = j;
        if (j < 0 || nums[j] != target) {
            end = -1;
        }
        return new int[]{start, end};
    }
}