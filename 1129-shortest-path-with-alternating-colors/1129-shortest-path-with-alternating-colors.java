class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        Map<Integer, List<Integer>> redmap = new HashMap<>();
        Map<Integer, List<Integer>> bluemap = new HashMap<>();
        
        buildGraph(redmap, redEdges);
        buildGraph(bluemap, blueEdges);
        
        int[] result = new int[n];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[0] = 0;
        Queue<int[]> queue = new LinkedList<>();
        // 0 is red, 1 is blue
        queue.offer(new int[]{0, 0});
        queue.offer(new int[]{0, 1});
        int level = 0;
        Set<String> visited = new HashSet<>();
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                int[] cur = queue.poll();
                int node = cur[0];
                if (!visited.add(node + "->" + cur[1])) continue;
                result[node] = Math.min(result[node], level);
                int nextColor = 1 - cur[1];
                if (nextColor == 0) {
                    if (redmap.containsKey(node)) {
                        for (int next : redmap.get(node)) {
                            queue.offer(new int[]{next, nextColor});
                        }
                    }
                } else {
                    if (bluemap.containsKey(node)) {
                        for (int next : bluemap.get(node)) {
                            queue.offer(new int[]{next, nextColor});
                        }
                    }
                }
            }
            level++;
        }
        for (int i = 1; i < n; i++) {
            if (result[i] == Integer.MAX_VALUE) {
                result[i] = -1;
            }
        }
        return result;
    }
    
    private void buildGraph(Map<Integer, List<Integer>> map, int[][] edges) {
        for (int[] cur : edges) {
            int from = cur[0];
            int to = cur[1];
            List<Integer> list1 = map.getOrDefault(from, new ArrayList<>());
            list1.add(to);
            map.put(from, list1);
        }
    }
}