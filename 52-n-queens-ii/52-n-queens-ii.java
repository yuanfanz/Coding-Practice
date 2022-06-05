class Solution {
    public int totalNQueens(int n) {
        return dfs(0, n, new boolean[n], new boolean[2*n-1], new boolean[2*n-1]);
    }
    private int dfs(int i, int n, boolean[] ocp90, boolean[] ocp45, boolean[] ocp135) {
        if (i == n) {
            return 1;
        }
        int count = 0;
        for (int j = 0; j < n; ++j) {
            if (!ocp90[j] && !ocp45[i + j] && !ocp135[n - 1 + i - j]) {
                ocp90[j] = true;
                ocp45[i + j] = true;
                ocp135[n - 1 + i - j] = true;
                count += dfs(i + 1, n, ocp90, ocp45, ocp135);
                ocp90[j] = false;
                ocp45[i + j] = false;
                ocp135[n - 1 + i - j] = false;
            }
        }
        return count;
    }
}