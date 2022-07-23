class Solution {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        
        for (int[] cur : edges) {
            int p = cur[0];
            int q = cur[1];
            graph.computeIfAbsent(p, k -> new ArrayList<>()).add(q);
        }
        // use DFS to find cycle
        int[] visited = new int[n];
        return dfs(graph, source, destination, visited);
    }
    
    private boolean dfs(Map<Integer, List<Integer>> graph, int cur, int destination, int[] visited) {
        visited[cur] = 1;
        if (graph.containsKey(cur)) {
            for (int next : graph.get(cur)) {
                if (visited[next] == 1) return false;
                if (visited[next] == 0) {
                    if (!dfs(graph, next, destination, visited)) return false;
                }
            }
        } else {
            // this is leaf node
            if (destination != cur) return false;
        }
        visited[cur] = 2;
        return true;
    }
}