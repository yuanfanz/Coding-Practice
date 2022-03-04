class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int sum = 0;
        int cur = 0;
        for (int i = 1; i < nums.length - 1; ++i) {
            if (nums[i] - nums[i - 1] == nums[i + 1] - nums[i]) {
                cur++;
                sum += cur;
            } else {
                cur = 0;
            }
        }
        return sum;
    }
}