class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (int[] cur : prerequisites) {
            int pre = cur[1];
            List<Integer> list = map.getOrDefault(pre, new ArrayList<>());
            list.add(cur[0]);
            map.put(pre, list);
        }
        int[] visited = new int[numCourses];
        Stack<Integer> deque = new Stack<>();
        for (int i = 0; i < numCourses; ++i) {
            if (visited[i] != 0) continue;
            if (dfs(visited, map, i, deque)) return new int[0];
        }
        int[] result = new int[deque.size()];
        int index = 0;
        while (deque.size() != 0) {
            result[index++] = deque.pop();
        }
        return result;
    }
    private boolean dfs(int[] visited, Map<Integer, List<Integer>> map, int cur, Stack<Integer> deque) {
        visited[cur] = 1;
        if (map.containsKey(cur)) {
            for (int next : map.get(cur)) {
                if (visited[next] == 1) return true;
                if (visited[next] == 0) {
                    if (dfs(visited, map, next, deque)) return true;
                }
            }
        }
        visited[cur] = 2;
        deque.push(cur);
        return false;
    }
}