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
        // int[] distance = new int[n + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{n, 0});
        int[] visited = new int[n + 1];
        Arrays.fill(visited, Integer.MAX_VALUE);
        visited[n] = 0;
        while (pq.size() > 0) {
            int[] cur = pq.poll();
            int node = cur[0];
            int dis = cur[1];
            if (map.containsKey(node)) {
                for (int next : map.get(node).keySet()) {
                    int nextDis = map.get(node).get(next) + dis;
                    if (nextDis < visited[next]) {
                        visited[next] = nextDis;
                        pq.offer(new int[]{next, nextDis});
                    }
                }
            }
        }
//         while(!pq.isEmpty()) {
//             int[] curr = pq.poll();
//             int node = curr[0];
// 			int weight = curr[1];
            
//             for(int nei : map.get(node).keySet()) {
//                 int w = weight + map.get(node).get(nei);
//                 if(w < visited[nei]) {
//                     visited[nei] = w;
//                     pq.offer(new int[]{ nei, w });
//                 }
//             }
//         }
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
                res = (res + dfs(distance, map, next, end, dp) % mod);
            }
        }
        res = res % mod;
        dp[cur] = (int) res;
        return dp[cur];
    }
}























