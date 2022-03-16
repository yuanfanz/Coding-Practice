class Solution {
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