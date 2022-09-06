class Solution {
    private int mod = (int) Math.pow(10, 9) + 7;
    public int numberOfWays(int startPos, int endPos, int k) {
        int[][] dp = new int[3000][k + 1];
        
        for (int i = 0; i < dp.length; ++i) {
            Arrays.fill(dp[i], -1);
        }
        return helper(dp, startPos, endPos, k);
    }
    
    private int helper(int[][] dp, int start, int end, int k) {
        if (start == end && k == 0) {
            return 1;
        }
        if (k == 0) {
            return 0;
        }
        if (dp[start + 1000][k] != -1) { // memo arr
            return dp[start + 1000][k];
        }
        int left = helper(dp, start - 1, end, k - 1);
        int right = helper(dp, start + 1, end, k - 1);
        
        dp[start + 1000][k] = (left + right) % mod;
        return dp[start + 1000][k];
    }
}