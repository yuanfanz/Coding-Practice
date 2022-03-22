class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int noncircularMax = maxSub(nums);
        int total = 0;
        for (int i = 0; i < nums.length; ++i) {
            total += nums[i];
            nums[i] = -nums[i];
        }
        int minSub = maxSub(nums);
        int circularMax = total + minSub;
        if (circularMax == 0) return noncircularMax;
        return Math.max(circularMax, noncircularMax);
    }
    
    private int maxSub(int[] nums) {
        int sum = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            sum = nums[i] + (sum > 0 ? sum : 0);
            max = Math.max(max, sum);
        }
        return max;
    }
}