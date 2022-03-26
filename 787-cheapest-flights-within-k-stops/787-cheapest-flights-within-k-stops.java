class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        
        for (int[] cur : flights) {
            int from = cur[0];
            int to = cur[1];
            Map<Integer, Integer> costMap = map.getOrDefault(from, new HashMap<>());
            costMap.put(to, cur[2]);
            map.put(from, costMap);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{src, 0, 0});
        int[] visited = new int[n];
        Arrays.fill(visited, -1);
        int min = Integer.MAX_VALUE;
        while (pq.size() > 0) {
            int[] cur = pq.poll();
            int node = cur[0];
            int cost = cur[1];
            int stops = cur[2];
            if (node == dst) {
                return cost;
            }
            if (visited[node] != -1 && visited[node] < stops) continue;
            visited[node] = stops;
            if (stops <= k) {
                if (map.containsKey(node)) {
                    for (int next : map.get(node).keySet()) {
                        int nextCost = map.get(node).get(next);
                        pq.offer(new int[]{next, cost + nextCost, stops + 1});
                    }
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}