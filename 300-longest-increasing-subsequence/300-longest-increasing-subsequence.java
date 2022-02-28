class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = 1;
        int n = nums.length;
        int[] sequence = new int[n];
        sequence[len - 1] = nums[0];
        for (int i = 1; i < n; ++i) {
            if (sequence[len - 1] >= nums[i]) {
                int index = search(sequence, nums[i], 0, len - 1);
                sequence[index] = nums[i];
            } else {
                sequence[len++] = nums[i];
            }
        }
        return len;
    }
    private int search(int[] nums, int target, int i, int j) {
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return i;
    }
}