class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        Set<Integer>[][] map = new HashSet[2][n];
        
        for (int i = 0; i < n; ++i) {
            map[0][i] = new HashSet<>();
            map[1][i] = new HashSet<>();
        }
        for (int[] red : red_edges) {
            map[0][red[0]].add(red[1]);
        }
        for (int[] blue : blue_edges) {
            map[1][blue[0]].add(blue[1]);
        }
        int[] result = new int[n];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[0] = 0;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        queue.offer(new int[]{0, 1});
        int len = 1;
        Set<String> visited = new HashSet<>();
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                int[] cur = queue.poll();
                int node = cur[0];
                int color = cur[1];
                int nextColor = 1 - color;
                for (int next : map[nextColor][node]) {
                    if (!visited.add(next + "" + nextColor)) continue;
                    queue.offer(new int[]{next, nextColor});
                    result[next] = Math.min(result[next], len);
                }
            }
            len++;
        }
        for (int i = 1; i < n; i++) {
            if (result[i] == Integer.MAX_VALUE) {
                result[i] = -1;
            }
        }
        return result;
    }
}




















