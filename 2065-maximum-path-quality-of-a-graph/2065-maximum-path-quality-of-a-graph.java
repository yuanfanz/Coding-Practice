class Solution {
    private int max = 0;
    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        // draw the graph first
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] cur : edges) {
            int from = cur[0];
            int to = cur[1];
            int cost = cur[2];
            Map<Integer, Integer> sub1 = map.getOrDefault(from, new HashMap<>());
            sub1.put(to, cost);
            map.put(from, sub1);
            Map<Integer, Integer> sub2 = map.getOrDefault(to, new HashMap<>());
            sub2.put(from, cost);
            map.put(to, sub2);
        }
        boolean[] visited = new boolean[values.length];
        dfs(0, map, values, maxTime, 0, 0, visited);
        return max;
    }
    
    private void dfs(int cur, Map<Integer, Map<Integer, Integer>> map,
                    int[] values, int maxTime, int sum, int time, boolean[] visited) {
        if (time > maxTime) return;
        boolean added = false;
        if (!visited[cur]) {
            added = true;
            sum += values[cur];
        }
        visited[cur] = true;
        
        if (cur == 0) {
            max = Math.max(max, sum);
        }
        
        if (map.containsKey(cur)) {
            for (int next : map.get(cur).keySet()) {
                int nextTime = map.get(cur).get(next);
                dfs(next, map, values, maxTime, sum, time + nextTime, visited);
            }
        }
        if (added) {
            visited[cur] = false;
            sum -= values[cur];
        }
    }
}




















