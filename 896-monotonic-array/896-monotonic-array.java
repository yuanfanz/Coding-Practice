class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean increase = false;
        boolean decrease = false;
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i + 1] == nums[i]) continue;
            if (nums[i + 1] > nums[i]) {
                if (!increase && !decrease) {
                    increase = true;
                } else {
                    if (!increase) return false;
                }
            } else {
                if (!increase && !decrease) {
                    decrease = true;
                } else {
                    if (!decrease) return false;
                }
            }
        }
        return true;
    }
}