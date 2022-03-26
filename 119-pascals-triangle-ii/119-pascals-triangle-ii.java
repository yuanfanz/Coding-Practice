class Solution {
    public List<Integer> getRow(int rowIndex) {
        int[][] dp = new int[rowIndex + 2][rowIndex + 2];
        
        dp[0][0] = 1;
        for (int i = 1; i <= rowIndex + 1; ++i) {
            for (int j = 1; j <= rowIndex + 1; ++j) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= rowIndex + 1; ++i) {
            result.add(dp[rowIndex + 1][i]);
        }
        return result;
    }
}