class Solution {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        
        Set<Integer> set = new HashSet<>();
        for (int i : grid[grid.length - 1]) {
            set.add(i);
        }
        for (int i = 0; i < grid.length - 1; ++i) {
            int[] nextArr = grid[i + 1];
            for (int cur : grid[i]) {
                int[] cost = moveCost[cur];
                Map<Integer, Integer> submap = map.getOrDefault(cur, new HashMap<>());
                for (int j = 0; j < nextArr.length; ++j) {
                    submap.put(nextArr[j], cost[j]);
                }
                map.put(cur, submap);
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int[] visited = new int[moveCost.length];
        Arrays.fill(visited, -1);
        for (int cur : grid[0]) {
            pq.offer(new int[]{cur, cur});
        }
        while (pq.size() > 0) {
            int[] cur = pq.poll();
            int node = cur[0];
            int cost = cur[1];
            if (set.contains(node)) {
                return cost;
            }
            if (visited[node] != -1 && cost > visited[node]) continue;
            visited[node] = cost;
            if (map.containsKey(node)) {
                Map<Integer, Integer> submap = map.get(node);
                for (int key : submap.keySet()) {
                    pq.offer(new int[]{key, cost + submap.get(key) + key});
                }
            }
        }
        return -1;
    }
}



















