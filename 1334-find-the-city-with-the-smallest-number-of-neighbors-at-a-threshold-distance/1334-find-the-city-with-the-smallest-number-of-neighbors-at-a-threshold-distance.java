class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        
        for (int[] cur : edges){
            int from = cur[0];
            int to = cur[1];
            int cost = cur[2];
            if (!map.containsKey(from)) map.put(from, new HashMap<>());
            if (!map.containsKey(to)) map.put(to, new HashMap<>());
            map.get(from).put(to, cost);
            map.get(to).put(from, cost);
        }
        Map<Integer, Integer> costMap = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; ++i) {
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{i, 0});
            Set<Integer> set = new HashSet<>();
            int[] visited = new int[n];
            Arrays.fill(visited, Integer.MAX_VALUE);
            while (queue.size() > 0) {
                int[] cur = queue.poll();
                int node = cur[0];
                int dis = cur[1];
                if (dis >= visited[node]) continue;
                visited[node] = dis;
                set.add(node);
                if (map.containsKey(node)) {
                    for (int next : map.get(node).keySet()) {
                        int newDis = dis + map.get(node).get(next);
                        if (newDis <= distanceThreshold) {
                            queue.offer(new int[]{next, newDis});
                        }
                    }
                }
            }
            costMap.put(i, set.size());
            min = Math.min(min, set.size());
        }
        int target = -1;
        for (int i : costMap.keySet()) {
            if (costMap.get(i) == min) {
                target = target < i ? i : target;
            }
        }
        return target;
    }
}