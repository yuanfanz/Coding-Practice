class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int j = 0;
        int min = nums.length + 1;
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            while (j < nums.length && sum < target) {
                sum += nums[j++];
            }
            if (sum >= target) {
                if (j - i < min) {
                    min = j - i;
                }
            }
            sum -= nums[i];
        }
        return min == nums.length + 1 ? 0 : min;
    }
}