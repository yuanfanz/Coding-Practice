class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int sum = 0;
        // build graph
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            List<Integer> list = map.getOrDefault(manager[i], new ArrayList<>());
            list.add(i);
            map.put(manager[i], list);
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{headID, 0});
        int max = 0;
        while (queue.size() > 0) {
            int[] cur = queue.poll();
            int node = cur[0];
            max = Math.max(max, cur[1]);
            if (map.containsKey(node)) {
                for (int next : map.get(node)) {
                    queue.offer(new int[]{next, cur[1] + informTime[node]});
                }
            }
        }
        return max;
    }
}