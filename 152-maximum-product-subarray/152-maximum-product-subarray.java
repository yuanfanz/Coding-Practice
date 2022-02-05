class Solution {
    public int maxProduct(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        int product = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] < 0) {
                int tmp = min;
                min = max;
                max = tmp;
            }
            min = Math.min(nums[i], min * nums[i]);
            max = Math.max(nums[i], max * nums[i]);
            product = Math.max(product, max);
        }
        return product;
    }
}