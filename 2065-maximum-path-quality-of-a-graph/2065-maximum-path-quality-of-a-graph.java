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
        Map<Integer, Integer> shortestMap = dijkstra(map, values.length);
        boolean[] visited = new boolean[values.length];
        dfs(0, map, shortestMap, values, maxTime, 0, 0, visited);
        return max;
    }
    
    private void dfs(int cur, Map<Integer, Map<Integer, Integer>> map, Map<Integer, Integer> shortestMap,
                    int[] values, int maxTime, int sum, int time, boolean[] visited) {
        if (time > maxTime) return;
        
        // determine if we visited this point
        // each point can only add once
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
                if (shortestMap.get(next) > (maxTime + 1) / 2) continue;
                int nextTime = map.get(cur).get(next);
                dfs(next, map, shortestMap, values, maxTime, sum, time + nextTime, visited);
            }
        }
        // if added above, backtrack the value here
        if (added) {
            visited[cur] = false;
            sum -= values[cur];
        }
    }
    
    private Map<Integer, Integer> dijkstra(Map<Integer, Map<Integer, Integer>> map, int n) {
        Map<Integer, Integer> timeMap = new HashMap<>();
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{0, 0});
        int[] visited = new int[n];
        Arrays.fill(visited, Integer.MAX_VALUE);
        while (pq.size() > 0) {
            int[] cur = pq.poll();
            int node = cur[0];
            int dis = cur[1];
            if (visited[node] <= dis) continue;
            visited[node] = dis;
            timeMap.put(node, dis);
            if (map.containsKey(node)) {
                for (int next : map.get(node).keySet()) {
                    pq.offer(new int[]{next, dis + map.get(node).get(next)});
                }
            }
        }
        return timeMap;
    }
}



















