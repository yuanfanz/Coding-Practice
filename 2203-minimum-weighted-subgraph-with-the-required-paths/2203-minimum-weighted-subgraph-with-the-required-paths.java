class Solution {
    private long INF = Long.MAX_VALUE;
    public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {
        Map<Integer, Map<Integer, Integer>> forwardMap = buildGraph(edges, true);
        Map<Integer, Map<Integer, Integer>> backwardMap = buildGraph(edges, false);
        
        long[] dis1 = dijkstra(forwardMap, src1, n);
        long[] dis2 = dijkstra(forwardMap, src2, n);
        long[] dis3 = dijkstra(backwardMap, dest, n);
        
        long res = INF;
        for (int i = 0; i < n; ++i) {
            if (dis1[i] != INF && dis2[i] != INF && dis3[i] != INF) {
                res = Math.min(res, dis1[i] + dis2[i] + dis3[i]);
            }
        }
        return res == Long.MAX_VALUE ? -1 : res;
    }
    
    private Map<Integer, Map<Integer, Integer>> buildGraph(int[][] edges, boolean forward) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] cur : edges) {
            int from = cur[0];
            int to = cur[1];
            int weight = cur[2];
            if (!forward) {
                from = cur[1];
                to = cur[0];
            }
            Map<Integer, Integer> submap = map.getOrDefault(from, new HashMap<>());
            int value = weight;
            if (submap.containsKey(to)) {
                value = Math.min(value, submap.get(to));
            }
            submap.put(to, value);
            map.put(from, submap);
        }
        return map;
    }
    
    private long[] dijkstra(Map<Integer, Map<Integer, Integer>> map, int start, int n) {
        PriorityQueue<Node> pq = new PriorityQueue<Node>((a, b) -> Long.compare(a.dis, b.dis));
        pq.offer(new Node(start, 0));
        
        long[] visited = new long[n];
        Arrays.fill(visited, INF);
        while (pq.size() > 0) {
            Node cur = pq.poll();
            int pos = cur.pos;
            long dis = cur.dis;
            if (visited[pos] < dis) {
                continue;
            }
            visited[pos] = dis;
            if (map.containsKey(pos)) {
                for (int next : map.get(pos).keySet()) {
                    int cost = map.get(pos).get(next);
                    pq.offer(new Node(next, dis + (long) cost));
                }
            }
        }
        return visited;
    }
    
    class Node{
        int pos;
        long dis;
        public Node(int pos, long dis) {
            this.pos = pos;
            this.dis = dis;
        }
    }
}