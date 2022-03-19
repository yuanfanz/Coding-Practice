class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        int[][] dp = new int[numRows+1][numRows+1];
        dp[0][0] = 1;
        for (int i = 1; i <= numRows; ++i) {
            for (int j = 1; j <= numRows; ++j) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }
        for (int i = 1; i <= numRows; ++i) {
            List<Integer> list = new ArrayList<>();
            for (int j = 1; j < i + 1; ++j) {
                list.add(dp[i][j]);
            }
            result.add(list);
        }
        return result;
    }
}