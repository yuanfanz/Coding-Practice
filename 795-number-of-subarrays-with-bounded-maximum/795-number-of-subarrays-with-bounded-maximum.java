class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        return getSubArr(nums, right) - getSubArr(nums, left - 1);
    }
    
    private int getSubArr(int[] nums, int max) {
        int cur = 0;
        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] <= max) {
                cur++;
                res += cur;
            } else {
                cur = 0;
            }
        }
        return res;
    }
}