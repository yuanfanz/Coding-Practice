class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        int res = -1;
        
        for (int i = 0; i < nums.length - 1; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                int cur = nums[i] + nums[j];
                if (cur < k && cur > res) {
                    res = cur;
                }
            }
        }
        return res;
    }
}