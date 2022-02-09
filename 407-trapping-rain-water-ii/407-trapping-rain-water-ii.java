class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;
        
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for (int i = 0; i < m; ++i) {
            pq.offer(new int[]{i, 0, heightMap[i][0]});
            pq.offer(new int[]{i, n - 1, heightMap[i][n - 1]});
            visited[i][0] = visited[i][n - 1] = true;
        }
        for (int j = 1; j < n - 1; ++j) {
            pq.offer(new int[]{0, j, heightMap[0][j]});
            pq.offer(new int[]{m - 1, j, heightMap[m - 1][j]});
            visited[0][j] = visited[m - 1][j] = true;
        }
        int res = 0;
        while (pq.size() != 0) {
            int[] cur = pq.poll();
            int i = cur[0];
            int j = cur[1];
            int h = cur[2];
            for (int[] dir : dirs) {
                int row = i + dir[0];
                int col = j + dir[1];
                if (row < 0 || col < 0 || row >= m || col >= n || visited[row][col]) {
                    continue;
                }
                res += Math.max(0, h - heightMap[row][col]);
                visited[row][col] = true;
                pq.offer(new int[]{row, col, Math.max(h, heightMap[row][col])});
            }
        }
        return res;
    }
}