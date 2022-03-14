class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        HashSet<Integer>[][] map = new HashSet[2][n];
        
        // 0 is red
        // 1 is blue
        for (int i = 0; i < n; ++i) {
            map[0][i] = new HashSet<>();
            map[1][i] = new HashSet<>();
        }
        for (int[] cur : redEdges) {
            int from = cur[0];
            int to = cur[1];
            map[0][from].add(to);
        }
        for (int[] cur : blueEdges) {
            int from = cur[0];
            int to = cur[1];
            map[1][from].add(to);
        }
        int[] result = new int[n];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[0] = 0;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        queue.offer(new int[]{0, 1});
        int step = 0;
        Set<String> visited = new HashSet<>();
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                int[] cur = queue.poll();
                int node = cur[0];
                int color = cur[1];
                if (!visited.add(node + "->" + color)) continue;
                result[node] = Math.min(result[node], step);
                int nextColor = 1 - color;
                for (int next : map[nextColor][node]) {
                    queue.offer(new int[]{next, nextColor});
                }
            }
            step++;
        }
        for (int i = 1; i < n; i++) {
            if (result[i] == Integer.MAX_VALUE) {
                result[i] = -1;
            }
        }
        return result;
    }
}












