class Solution {
    public boolean validTree(int n, int[][] edges) {
        ArrayList[] chart = new ArrayList[n];
        
        for (int i = 0; i < n; ++i) {
            chart[i] = new ArrayList<>();
        }
        for (int[] cur : edges) {
            int first = cur[0];
            int second = cur[1];
            chart[first].add(second);
            chart[second].add(first);
        }
        int[] visited = new int[n];
        if (dfs(0, -1, visited, chart)) return false;
        
        for (int i = 0; i < n; ++i) {
            if (visited[i] == 0) return false;
        }
        return true;
    }
    private boolean dfs(int cur, int parent, int[] visited, ArrayList[] chart) {
        visited[cur] = 1;
        for (int i = 0; i < chart[cur].size(); ++i) {
            int next = (int) chart[cur].get(i);
            if (next == parent) continue;
            if (visited[next] == 1) return true;
            if (visited[next] == 0) {
                if (dfs(next, cur, visited, chart)) return true;
            }
        }
        visited[cur] = 2;
        return false;
    }
}