class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> result = new ArrayList<>();
        
        int n = graph.length;
        for (int i = 0; i < n; ++i) {
            int[] visited = new int[n];
            if (dfs(graph, i, visited)) {
                continue;
            }
            result.add(i);
        }
        return result;
    }
    private boolean dfs(int[][] graph, int cur, int[] visited) {
        visited[cur] = 1;
        for (int i = 0; i < graph[cur].length; ++i) {
            int next = graph[cur][i];
            if (visited[next] == 1) return true;
            if (visited[next] == 0) {
                if (dfs(graph, next, visited)) {
                    return true;
                }
            }
        }
        visited[cur] = 2;
        return false;
    }
}