class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int fullMask = (1 << n) - 1;
        
        Set<String> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        
        for (int i = 0; i < n; ++i) {
            queue.offer(new int[]{i, 1 << i});
            visited.add(i + "->" + (1 << i));
        }
        
        int level = 0;
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                int[] cur = queue.poll();
                int node = cur[0];
                int mask = cur[1];
                if (mask == fullMask) return level;
                for (int next : graph[node]) {
                    int nextMask = mask | (1 << next);
                    String path = next + "->" + nextMask;
                    if (visited.contains(path)) {
                        continue;
                    }
                    visited.add(path);
                    queue.offer(new int[]{next, nextMask});
                }
            }
            level++;
        }
        return level;
    }
}