class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList[] map = new ArrayList[numCourses];
        for (int i = 0; i < map.length; ++i) {
            map[i] = new ArrayList<>();
        }
        for (int[] cur : prerequisites) {
            int first = cur[1];
            int second = cur[0];
            map[first].add(second);
        }
        Deque<Integer> deque = new LinkedList<>();
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            if (dfs(i, visited, map, deque)) return new int[0];
        }
        return deque.stream().mapToInt(i -> i).toArray();
    }
    private boolean dfs(int cur, int[] visited, ArrayList[] map, Deque<Integer> deque) {
        if (visited[cur] == 2) return false;
        visited[cur] = 1;
        for (int i = 0; i < map[cur].size(); ++i) {
            int next = (int) map[cur].get(i);
            if (visited[next] == 1) return true;
            if (visited[next] == 0) {
                if (dfs(next, visited, map, deque)) return true;
            }
        }
        deque.addFirst(cur);
        visited[cur] = 2;
        return false;
    }
}