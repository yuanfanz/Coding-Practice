class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        
        for (int[] cur : times) {
            int from = cur[0];
            int to = cur[1];
            int cost = cur[2];
            Map<Integer, Integer> costMap = map.getOrDefault(from, new HashMap<>());
            costMap.put(to, cost);
            map.put(from, costMap);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, k});
        boolean[] visited = new boolean[n + 1];
        while (pq.size() > 0) {
            int[] cur = pq.poll();
            int node = cur[1];
            int cost = cur[0];
            if (visited[node]) continue;
            visited[node] = true;
            n--;
            if (n == 0) return cost;
            if (map.containsKey(node)) {
                for (int next : map.get(node).keySet()) {
                    pq.offer(new int[]{cost + map.get(node).get(next), next});
                }
            }
        }
        return -1;
    }
}