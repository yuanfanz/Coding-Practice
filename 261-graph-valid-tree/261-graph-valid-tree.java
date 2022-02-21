class Solution {
    public boolean validTree(int n, int[][] edges) {
        ArrayList[] map = new ArrayList[n];
        
        for (int i = 0; i < n; ++i) {
            map[i] = new ArrayList<>();
        }
        for (int[] cur : edges) {
            int first = cur[0];
            int second = cur[1];
            map[first].add(second);
            map[second].add(first);
        }
        int[] visited = new int[n];
        if (dfs(visited, map, 0, -1)) {
            return false;
        }
        for (int i = 0; i < visited.length; ++i) {
            if (visited[i] == 0) {
                return false;
            }
        }
        return true;
    }
    private boolean dfs(int[] visited, ArrayList[] map, int cur, int parent) {
        visited[cur] = 1;
        for (int i = 0; i < map[cur].size(); ++i) {
            int next = (int) map[cur].get(i);
            if (next == parent) continue;
            if (visited[next] == 1) return true;
            if (visited[next] == 0) {
                if (dfs(visited, map, next, cur)) {
                    return true;
                }
            }
        }
        visited[cur] = 2;
        return false;
    }
}