class Solution {
    public boolean canPlaceFlowers(int[] nums, int n) {
        if (n == 0) {
            return true;
        }
        int count = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 0) {
                int prev = (i == 0) ? 0 : nums[i - 1];
                int next = (i == nums.length - 1) ? 0 : nums[i + 1];
                if (prev == 0 && next == 0) {
                    nums[i] = 1;
                    count++;
                }
            }
            if (count == n) {
                return true;
            }
        }
        return count == n;
    }
}