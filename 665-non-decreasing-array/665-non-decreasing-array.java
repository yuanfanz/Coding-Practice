class Solution {
    public boolean checkPossibility(int[] nums) {
        int count = 0;
        
        for (int i = 1; i < nums.length; ++i) {
            // 3 4 2 3
            //     i
            if (nums[i] < nums[i - 1]) {
                if (count > 0) return false;
                int low = Math.min(nums[i], nums[i - 1]);
                int high = Math.max(nums[i], nums[i - 1]);
                // 1st case
                boolean first = true;
                boolean second = true;
                if (i - 1 > 0) {
                    int prev = nums[i - 2];
                    if (prev > low) first = false;
                }
                if (i + 1 < nums.length) {
                    if (nums[i + 1] < high) second = false;
                }
                if (!first && !second) {
                    return false;
                }
                count++;
            }
        }
        return true;
    }
}