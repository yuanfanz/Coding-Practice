class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int j = 0;
        int sum = 0;
        int min = nums.length;
        boolean flag = false;
        for (int i = 0; i < nums.length; ++i) {
            while (j < nums.length) {
                if (sum >= target) {
                    break;
                }
                sum += nums[j];
                j++;
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