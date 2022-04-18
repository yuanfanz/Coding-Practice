class Solution {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        int n = passingFees.length;
        for (int[] cur : edges) {
            int p = cur[0];
            int q = cur[1];
            int time = cur[2];
            List<int[]> l1 = map.getOrDefault(p, new ArrayList<>());
            List<int[]> l2 = map.getOrDefault(q, new ArrayList<>());
            l1.add(new int[]{q, time});
            l2.add(new int[]{p, time});
            map.put(p, l1);
            map.put(q, l2);
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{0, passingFees[0], 0});
        int[] visited = new int[n];
        Arrays.fill(visited, Integer.MAX_VALUE);
        while (pq.size() > 0) {
            int[] cur = pq.poll();
            int node = cur[0];
            int cost = cur[1];
            int time = cur[2];
            
            if (time >= visited[node] || time > maxTime) continue;
            
            if (node == n - 1) return cost;
            
            visited[node] = time;
            
            if (map.containsKey(node)) {
                for (int[] arr : map.get(node)) {
                    int next = arr[0];
                    int nextTime = arr[1];
                    pq.offer(new int[]{next, cost + passingFees[next], 
                                       time + nextTime});
                }
            }
        }
        return -1;
    }
}



















