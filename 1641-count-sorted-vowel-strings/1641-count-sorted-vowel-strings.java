class Solution {
    public int countVowelStrings(int n) {
        int[] dp = new int[5];
        
        Arrays.fill(dp, 1);
        for (int i = 2; i <= n; ++i) {
            int sum = 0;
            for (int j = 4; j >= 0; --j) {
                sum += dp[j];
                dp[j] = sum;
            }
        }
        int res = 0;
        for (int i : dp) {
            res += i;
        }
        return res;
    }
}