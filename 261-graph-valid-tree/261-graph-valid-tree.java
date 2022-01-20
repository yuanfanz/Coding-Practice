class Solution {
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] cur : edges) {
            int first = cur[0];
            int second = cur[1];
            List<Integer> list1 = map.getOrDefault(first, new ArrayList<>());
            List<Integer> list2 = map.getOrDefault(second, new ArrayList<>());
            list1.add(second);
            list2.add(first);
            map.put(first, list1);
            map.put(second, list2);
        }
        
        boolean[] visited = new boolean[n];
        if (dfs(0, -1, visited, map)) return false;
        for (boolean cur : visited) {
            if (!cur) return false;
        }
        return true;
    }
    private boolean dfs(int cur, int parent, boolean[] visited, Map<Integer, List<Integer>> map) {
        visited[cur] = true;
        if (map.containsKey(cur)) {
            for (int next : map.get(cur)) {
                if (next == parent) continue;
                if (visited[next] || dfs(next, cur, visited, map)) {
                    return true;
                }
            }
        }
        return false;
    }
}