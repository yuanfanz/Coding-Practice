class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        
        int nonCircularMax = maxSubArray(nums);
        int totalSum = 0;
        for (int i = 0; i < n; ++i) {
            totalSum += nums[i];
            nums[i] = -nums[i];
        }
        // after inverting every number sign
        // we can calculate min sub array sum using same method
        int minSubArraySum = maxSubArray(nums);
        int circularMax = totalSum + minSubArraySum;
        
        // if all numbers are negtive, totalSum == minSubArraySum
        // circularMax will be 0
        if (circularMax == 0) {
            return nonCircularMax;
        }
        return Math.max(circularMax, nonCircularMax);
    }
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        
        int[] presum = new int[n];
        presum[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < n; ++i) {
            presum[i] = nums[i] + (presum[i - 1] > 0 ? presum[i - 1] : 0);
            max = Math.max(max, presum[i]);
        }
        return max;
    }
}