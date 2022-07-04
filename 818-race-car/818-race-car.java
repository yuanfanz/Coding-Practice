class Solution {
    public int racecar(int target) {
        int[] dp = new int[target + 2];
        
        dp[1] = 1;
        dp[2] = 4;
        
        // k is multiple A operation
        int k = 2;
        int s = 3;
        for (int i = 3; i <= target; ++i) {
            // 1. we can go to i only using A operation
            // cause i is 2^n - 1
            if (i == s) {
                dp[i] = k++;
                s = (int) Math.pow(2, k) - 1;
            } else {
                // 2. we go beyond the distance, we need to go back after K times A operation
                // backward distance: s - i
                dp[i] = k + 1 + dp[s - i];
                
                // 3. we go (k - 1) times A operation, then go back, then go forward
                // backward distance: 2^back - 1, we are not sure about exact value of back
                // forward distance: (i - (2^(k-1) - 1)) + backward distance
                for (int back = 0; back <= k - 2; ++back) {
                    int distance = i - ((int) Math.pow(2, k - 1) - 1) + ((int) Math.pow(2, back) - 1);
                    dp[i] = Math.min(dp[i], k - 1 + 2 + back + dp[distance]);
                }
            }
        }
        return dp[target];
    }
}












