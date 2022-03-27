class Solution {
    public int minimumCost(int n, int[][] highways, int discounts) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        
        for (int[] cur : highways) {
            int from = cur[0];
            int to = cur[1];
            Map<Integer, Integer> costMap1 = map.getOrDefault(from, new HashMap<>());
            Map<Integer, Integer> costMap2 = map.getOrDefault(to, new HashMap<>());
            costMap1.put(to, cur[2]);
            costMap2.put(from, cur[2]);
            map.put(from, costMap1);
            map.put(to, costMap2);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        // node, discount, cost
        pq.offer(new int[]{0, 0, 0});
        int[][] visited = new int[n][discounts + 1];
        for (int[] cur : visited) {
            Arrays.fill(cur, Integer.MAX_VALUE);
        }
        visited[0][0] = 0;
        while (pq.size() > 0) {
            int[] cur = pq.poll();
            int node = cur[0];
            int discountUsed = cur[1];
            int cost = cur[2];
            if (node == n - 1) {
                return cost;
            }
            if (map.containsKey(node)) {
                for (int next : map.get(node).keySet()) {
                    int weight = map.get(node).get(next);
                    int normalCost = cost + weight;
                    if (normalCost < visited[next][discountUsed]) {
                        pq.offer(new int[]{next, discountUsed, normalCost});
                        visited[next][discountUsed] = normalCost;
                    }
                    // or use dicounted cost if there is any
                    int dicountedCost = cost + (weight / 2);
                    if (discountUsed < discounts && dicountedCost < visited[next][discountUsed + 1]) {
                        pq.offer(new int[]{next, discountUsed + 1, dicountedCost});
                        visited[next][discountUsed + 1] = dicountedCost;
                    }
                }
            }
        }
        return -1;
    }
}













