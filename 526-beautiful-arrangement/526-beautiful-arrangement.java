class Solution {
    int count = 0;
    public int countArrangement(int n) {
        if (n == 0) return 0;
        dfs(n, 1, new boolean[n + 1]);
        return count;
    }
    private void dfs(int n, int index, boolean[] visited) {
        if (index > n) {
            count++;
            return;
        }
        for (int i = 1; i <= n; ++i) {
            if (visited[i]) continue;
            if (valid(i, index)) {
                visited[i] = true;
                dfs(n, index + 1, visited);
                visited[i] = false;
            }
        }
    }
    private boolean valid(int a, int b) {
        return a % b == 0 || b % a == 0;
    }
}