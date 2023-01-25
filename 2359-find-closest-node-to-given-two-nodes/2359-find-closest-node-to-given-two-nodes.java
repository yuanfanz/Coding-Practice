class Solution {
    private int INTINF = Integer.MAX_VALUE;
    private long INF = Long.MAX_VALUE;
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < edges.length; ++i) {
            int from = i;
            int to = edges[i];
            int dis = 1;
            if (to == -1) {
                continue;
            }
            Map<Integer, Integer> submap = map.getOrDefault(from, new HashMap<>());
            submap.put(to, dis);
            map.put(from, submap);
        }
        int n = edges.length;
        int[] dis1 = dijkstra(map, node1, n);
        int[] dis2 = dijkstra(map, node2, n);
        
        // print(dis1);
        // System.out.println("***");
        // print(dis2);
        // System.out.println("***");
        
        long dis = INF;
        int res = -1;
        
        for (int i = 0; i < edges.length; ++i) {
            long cur = 0;
            // if (node1 == i) {
            //     cur = dis2[i];
            // } else if (node2 == i) {
            //     cur = dis1[i];
            // } else {
                cur = Math.max((long)dis1[i], (long)dis2[i]);
            // }
            
            // System.out.println(cur);
            if (cur < dis && cur < INTINF) {
                dis = cur;
                res = i;
            }
        }
        return res;
    }
    
    private int[] dijkstra(Map<Integer, Map<Integer, Integer>> map, int start, int n) {
        PriorityQueue<Node> pq = new PriorityQueue<Node>((a, b) -> a.dis - b.dis);
        pq.offer(new Node(start, 0));
        
        int[] visited = new int[n];
        Arrays.fill(visited, INTINF);
        while (pq.size() > 0) {
            Node cur = pq.poll();
            int pos = cur.pos;
            int dis = cur.dis;
            if (visited[pos] < dis) {
                continue;
            }
            visited[pos] = dis;
            if (map.containsKey(pos)) {
                for (int next : map.get(pos).keySet()) {
                    int cost = map.get(pos).get(next);
                    pq.offer(new Node(next, dis + cost));
                }
            }
        }
        return visited;
    }
    
    class Node{
        int pos;
        int dis;
        public Node(int pos, int dis) {
            this.pos = pos;
            this.dis = dis;
        }
    }
    
    private void print(int[] grid) {
    for (int i = 0; i < grid.length; ++i) {
        System.out.print(grid[i] + " ");
    }
    System.out.println();
}
}