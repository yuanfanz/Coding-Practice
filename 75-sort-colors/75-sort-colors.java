class Solution {
    public void sortColors(int[] nums) {
        int zeroPtr = 0;
        int twoPtr = nums.length - 1;
        for (int i = 0; i < nums.length; ++i) {
            while (nums[i] == 2 && i < twoPtr) {
                swap(nums, i, twoPtr--);
            }
            while (nums[i] == 0 && zeroPtr < i) {
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