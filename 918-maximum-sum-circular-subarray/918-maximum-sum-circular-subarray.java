class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        
        int firstSum = getSum(nums);
        
        int[] arr = new int[n];
        int total = 0;
        for (int i = 0; i < n; ++i) {
            arr[i] = -nums[i];
            total += nums[i];
        }
        
        int minSum = getSum(arr);
        if (total + minSum == 0) return firstSum;
        return Math.max(firstSum, total + minSum);
    }
    
    private int getSum(int[] nums) {
        int presum = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            presum = nums[i] + (presum > 0 ? presum : 0);
            max = Math.max(max, presum);
        }
        return max;
    }
}