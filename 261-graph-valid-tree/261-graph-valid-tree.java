class Solution {
    public boolean validTree(int n, int[][] edges) {
        List[] map = new ArrayList[n];
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
        if (dfs(0, -1, visited, map)) {
            return false;
        }
        for (int i = 0; i < n; ++i) {
            if (visited[i] == 0) {
                return false;
            }
        }
        return true;
    }
    private boolean dfs(int cur, int parent, int[] visited, List[] map) {
        visited[cur] = 1;
        for (int i = 0; i < map[cur].size(); ++i) {
            int next = (int) map[cur].get(i);
            if (next == parent) continue;
            if (visited[next] == 1) {
                return true;
            }
            if (visited[next] == 0) {
                if (dfs(next, cur, visited, map)) {
                    return true;
                }
            }
        }
        return false;
    }
}