class Solution {
    public int minScore(int n, int[][] roads) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] cur : roads){
            if (!map.containsKey(cur[0])) map.put(cur[0], new HashMap<>());
            if (!map.containsKey(cur[1])) map.put(cur[1], new HashMap<>());
            map.get(cur[0]).put(cur[1], cur[2]);
            map.get(cur[1]).put(cur[0], cur[2]);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{1, Integer.MAX_VALUE});
        int[] visited = new int[n + 1];
        Arrays.fill(visited, -1);
        int min = Integer.MAX_VALUE;
        while (pq.size() > 0) {
            int[] cur = pq.poll();
            int node = cur[0];
            int cost = cur[1];
            if (node == n) {
                min = Math.min(min, cost);
            }
            if (visited[node] != -1 && visited[node] <= cost) continue;
            visited[node] = cost;
            
            if (map.containsKey(node)) {
                for (int next : map.get(node).keySet()) {
                    int nextCost = map.get(node).get(next);
                    int actual = Math.min(cost, nextCost);
                    pq.offer(new int[]{next, actual});
                }
            }
        }
        return min;
    }
}