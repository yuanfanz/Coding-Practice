class Solution {
    public boolean validPartition(int[] nums) {
        int n = nums.length;
        
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        
        for (int i = 2; i <= n; ++i) {
            if (nums[i - 2] == nums[i - 1]) {
                dp[i] = dp[i] || dp[i - 2];
            }  
            if (i >= 3) {
                
//                 System.out.println(nums[i - 1]);
//                 System.out.println(nums[i - 2]);
//                 System.out.println(nums[i - 3]);
                
//                 System.out.println(nums[i - 1] - nums[i - 2]);
//                 System.out.println(nums[i - 2] - nums[i - 3]);
                
                if ((nums[i - 1] - nums[i - 2] == 1 && nums[i - 2] - nums[i - 3] == 1)
                   || (nums[i - 1] == nums[i - 2] && nums[i - 2] == nums[i - 3])) {
                    dp[i] = dp[i] || dp[i - 3];
                }
            }
        }
        // print(dp);
        return dp[n];
    }
    private void print(boolean[] grid) {
        for (int i = 0; i < grid.length; ++i) {
            System.out.print(grid[i] + " ");
        }
        System.out.println();
    }
}