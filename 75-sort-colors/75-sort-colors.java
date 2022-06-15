class Solution {
    public void sortColors(int[] nums) {
        int zero = 0;
        int two = nums.length - 1;
        for (int i = 0; i <= two; ++i) {
            while (i < two && nums[i] == 2) {
                swap(nums, i, two--);
            }
            while (i > zero && nums[i] == 0) {
                swap(nums, i, zero++);
            }
        }
    }
    private void swap(int[] nums, int i, int j) {
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }
}