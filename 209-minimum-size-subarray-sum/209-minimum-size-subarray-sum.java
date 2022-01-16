class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int j = 0;
        int min = nums.length;
        int sum = 0;
        boolean flag = false;
        for (int i = 0; i < nums.length; ++i) {
            while (j < nums.length && sum < target) {
                sum += nums[j++];
            }
            if (sum >= target) {
                flag = true;
                min = Math.min(min, j - i);
            }
            sum -= nums[i];
        }
        return flag ? min : 0;
    }
}