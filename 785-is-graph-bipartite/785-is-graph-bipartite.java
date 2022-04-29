class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        
        for (int i = 0; i < n; ++i) {
            if (colors[i] != 0) continue;
            colors[i] = 1;
            if (!dfs(graph, i, colors, 1)) return false;
        }
        return true;
    }
    private boolean dfs(int[][] graph, int cur, int[] colors, int color) {
        for (int next : graph[cur]) {
            if (colors[next] == color) {
                return false;
            }
            if (colors[next] == 0) {
                colors[next] = -color;
                if (!dfs(graph, next, colors, -color)) return false;
            }
        }
        return true;
    }
}