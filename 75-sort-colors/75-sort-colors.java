class Solution {
    public void sortColors(int[] nums) {
        int zero = 0;
        int two = nums.length - 1;
        for (int i = 0; i < nums.length; ++i) {
            while (i < two && nums[i] == 2) {
                swap(i, two--, nums);
            }
            while (i > zero && nums[i] == 0) {
                swap(i, zero++, nums);
            }
        }
    }
    
    private void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}