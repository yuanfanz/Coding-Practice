class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        
        int[] sequence = new int[n];
        int len = 1;
        sequence[0] = nums[0];
        for (int i = 1; i < n; ++i) {
            if (sequence[len - 1] >= nums[i]) {
                int index = search(sequence, 0, len - 1, nums[i]);
                sequence[index] = nums[i];
            } else {
                sequence[len++] = nums[i];
            }
        }
        return len;
    }
    private int search(int[] nums, int i, int j, int target) {
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