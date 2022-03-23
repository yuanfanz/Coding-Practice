class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int twoPtr = n - 1;
        int zeroPtr = 0;
        for (int i = 0; i < n; ++i) {
            while (i < twoPtr && nums[i] == 2) {
                swap(nums, i, twoPtr--);
            }
            while (i > zeroPtr && nums[i] == 0) {
                swap(nums, i, zeroPtr++);
            }
        }
    }
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}