class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        ArrayList[] graph = new ArrayList[n + 1];
        
        for (int i = 1; i <= n; ++i) {
            graph[i] = new ArrayList<>();
        }
        for (int[] cur : dislikes) {
            int p = cur[0];
            int q = cur[1];
            graph[p].add(q);
            graph[q].add(p);
        }
        for (int i = 1; i <= n; ++i) {
            int[] colors = new int[n + 1];
            colors[i] = 1;
            if (!dfs(graph, i, colors, 1)) return false;
        }
        return true;
    }
    private boolean dfs(ArrayList[] graph, int cur, int[] colors, int color) {
        for (int i = 0; i < graph[cur].size(); ++i) {
            int next = (int) graph[cur].get(i);
            if (colors[next] == color) return false;
            if (colors[next] == 0) {
                colors[next] = -color;
                if (!dfs(graph, next, colors, -color)) return false;
            }
        }
        return true;
    }
}