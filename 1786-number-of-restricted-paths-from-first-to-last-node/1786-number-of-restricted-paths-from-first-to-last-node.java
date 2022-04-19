class Solution {
    int mod = (int) Math.pow(10, 9) + 7;
    
    public int countRestrictedPaths(int n, int[][] edges) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        
        for (int[] cur : edges) {
            int from = cur[0];
            int to = cur[1];
            Map<Integer, Integer> costMap1 = map.getOrDefault(from, new HashMap<>());
            Map<Integer, Integer> costMap2 = map.getOrDefault(to, new HashMap<>());
            costMap1.put(to, cur[2]);
            costMap2.put(from, cur[2]);
            map.put(from, costMap1);
            map.put(to, costMap2);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{n, 0});
        int[] visited = new int[n + 1];
        Arrays.fill(visited, Integer.MAX_VALUE);
        while (pq.size() > 0) {
            int[] cur = pq.poll();
            int node = cur[0];
            int dis = cur[1];
            if (dis >= visited[node]) continue;
            visited[node] = dis;
            if (map.containsKey(node)) {
                for (int next : map.get(node).keySet()) {
                    int nextDis = map.get(node).get(next);
                    pq.offer(new int[]{next, nextDis + dis});
                }
            }
        }
        Integer[] dp = new Integer[n + 1];
        return dfs(visited, map, 1, n, dp);
    }
    
    private int dfs(int[] distance, Map<Integer, Map<Integer, Integer>> map,
                    int cur, int end, Integer[] dp) {
        if (cur == end) {
            return 1;
        }
        if (dp[cur] != null) return dp[cur];
        long res = 0;
        for (int next : map.get(cur).keySet()) {
            if (distance[cur] > distance[next]) {
                res += dfs(distance, map, next, end, dp) % mod;
            }
        }
        res %= mod;
        dp[cur] = (int) res;
        return dp[cur];
    }
}