class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int j = 0;
        int sum = 0;
        boolean flag = false;
        int min = nums.length + 1;
        for (int i = 0; i < nums.length; ++i) {
            while (j < nums.length && sum < target) {
                sum += nums[j++];
            }
            if (sum >= target) {
                flag = true;
                if (min > j - i) {
                    min = j - i;
                }
            }
            sum -= nums[i];
        }
        return flag ? min : 0;
    }
}