class Solution {
    public int rob(int[] nums) {
        if (nums.length < 2) return nums[0];
        
        return Math.max(robStartWith(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                        robStartWith(Arrays.copyOfRange(nums, 1, nums.length)));
    }
    private int robStartWith(int[] nums) {
        if (nums.length < 2) return nums[0];
        int n = nums.length;
        int[] dp = new int[2];
        
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; ++i) {
            dp[i%2] = Math.max(dp[(i - 2)%2] + nums[i], dp[(i - 1)%2]);
        }
        return dp[(n - 1)%2];
    }
}