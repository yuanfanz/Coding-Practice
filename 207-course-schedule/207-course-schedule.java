class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList[] map = new ArrayList[numCourses];
        for (int i = 0; i < map.length; ++i) {
            map[i] = new ArrayList<>();
        }
        for (int[] cur : prerequisites) {
            int first = cur[1];
            int second = cur[0];
            map[first].add(second);
        }
        for (int i = 0; i < numCourses; ++i) {
            int[] visited = new int[numCourses];
            if (dfs(i, visited, map)) return false;
        }
        return true;
    }
    private boolean dfs(int cur, int[] visited, ArrayList[] map) {
        visited[cur] = 1;
        for (int i = 0; i < map[cur].size(); ++i) {
            int next = (int) map[cur].get(i);
            if (visited[next] == 1) return true;
            if (visited[next] == 0) {
                if (dfs(next, visited, map)) return true;
            }
        }
        visited[cur] = 2;
        return false;
    }
}