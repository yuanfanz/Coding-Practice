class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < n; ++i) {
            int head = manager[i];
            List<Integer> list = map.getOrDefault(head, new ArrayList<>());
            list.add(i);
            map.put(head, list);
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{headID, 0});
        int max = 0;
        while (queue.size() > 0) {
            int[] cur = queue.poll();
            int node = cur[0];
            int cost = cur[1];
            max = Math.max(max, cost);
            if (!map.containsKey(node)) continue;
            for (int next : map.get(node)) {
                queue.offer(new int[]{next, cost + informTime[node]});
            }
        }
        return max;
    }
}