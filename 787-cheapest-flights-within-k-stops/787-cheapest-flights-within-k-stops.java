class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        
        for (int[] cur : flights) {
            int from = cur[0];
            if (!map.containsKey(from)) map.put(from, new HashMap<>());
            map.get(from).put(cur[1], cur[2]);
        }
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, src, k + 1, 0});
        Set<Integer> set = new HashSet<>();
        int[] visited = new int[n];
        Arrays.fill(visited, -1);
        while (pq.size() != 0) {
            int[] cur = pq.poll();
            int dis = cur[0];
            int node = cur[1];
            int stop = cur[2];
            int move = cur[3];
            if (node == dst) return dis;
            if (visited[node] != -1 && visited[node] < move) continue;
            visited[node] = move;
            if (stop > 0) {
                if (map.containsKey(node)) {
                    for (int next : map.get(node).keySet()) {
                        pq.offer(new int[]{dis + map.get(node).get(next), next, stop - 1, move + 1});
                    }
                }
            }
        }
        return -1;
    }
}