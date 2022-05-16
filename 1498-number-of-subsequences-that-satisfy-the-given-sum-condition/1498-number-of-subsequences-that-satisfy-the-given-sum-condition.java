class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        
        int mod = (int) Math.pow(10, 9) + 7;
        int total = 0;
        
        // It is impossible to use 2^n in Java when n is very large, but Python can
        // So we need to use DP-method to pre-calculate 2^n % 1e9+7
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < dp.length; ++i) {
            dp[i] = (dp[i - 1] * 2) % mod;
        }
        
        for (int start = 0; start < nums.length; ++start) {
            if (nums[start] == target) break;
            int i = start;
            int j = nums.length - 1;
            int end = -1;
            while (i <= j) {
                int mid = i + (j - i) / 2;
                if (nums[mid] + nums[start] <= target) {
                    end = mid;
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }
            }
            if (end == -1) break;
            total = (total + dp[end - start]) % mod;
        }
        return total;
    }
}