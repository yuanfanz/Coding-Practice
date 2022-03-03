class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int zero = 0;
        int two = n - 1;
        
        for (int i = 0; i <= two; ++i) {
            while (i < two && nums[i] == 2) {
                swap(nums, i, two--);
            }
            while (zero < i && nums[i] == 0) {
                swap(nums, i, zero++);
            }
        }
    }
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}