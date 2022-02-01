class Solution {
    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; ++i) {
            max = Math.max(i + nums[i], max);
            if (i == nums.length - 1 || max >= nums.length - 1) {
                return true;
            }
            if (max == i) {
                return false;
            }
        }
        return false;
    }
}