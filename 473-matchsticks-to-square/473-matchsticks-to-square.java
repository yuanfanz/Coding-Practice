class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for (int i : matchsticks) {
            sum += i;
        }
        if (sum % 4 != 0) return false;
        int edge = sum / 4;
        
        int n = matchsticks.length;
        Arrays.sort(matchsticks);
        boolean[] visited = new boolean[n];
        return dfs(matchsticks, n - 1, 4, 0, edge, visited);
    }
    
    private boolean dfs(int[] matchsticks, int index, int cur, int sum, int edge, boolean[] visited) {
        if (cur == 0) return true;
        if (sum == edge && dfs(matchsticks, matchsticks.length - 1, cur - 1, 0, edge, visited)) {
            return true;
        }
        
        for (int i = index; i >= 0; --i) {
            if (!visited[i] && sum + matchsticks[i] <= edge) {
                visited[i] = true;
                if (dfs(matchsticks, i - 1, cur, sum + matchsticks[i], edge, visited)) return true;
                visited[i] = false;
            }
        }
        return false;
    }
}