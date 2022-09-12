class Solution {
    private int mod = (int) Math.pow(10, 9) + 7;
    public int checkRecord(int n) {
        int[][][] memo = new int[n][2][3];
        return dfs(0, n, 0, 0, memo);
    }
    
    private int dfs(int day, int n, int absent, int late, int[][][] memo) {
        if (day >= n) {
            return 1;
        }
        if (memo[day][absent][late] != 0) {
            return memo[day][absent][late];
        }
        int res = 0;
        res = (res + dfs(day + 1, n, absent, 0, memo)) % mod;
        if (absent < 1) {
            res = (res + dfs(day + 1, n, absent + 1, 0, memo)) % mod;
        }
        if (late < 2) {
            res = (res + dfs(day + 1, n, absent, late + 1, memo)) % mod;
        }
        memo[day][absent][late] = res;
        return res;
    }
}