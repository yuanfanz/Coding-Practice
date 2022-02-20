class Solution {
    public int maxProduct(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] < 0) {
                int tmp = min;
                min = max;
                max = tmp;
            }
            min = Math.min(min * nums[i], nums[i]);
            max = Math.max(max * nums[i], nums[i]);
            res = Math.max(res, max);
        }
        return res;
    }
}