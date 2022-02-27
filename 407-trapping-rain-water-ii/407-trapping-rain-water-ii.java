class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        boolean[][] visited = new boolean[m][n];
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
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        int res = 0;
        while (pq.size() > 0) {
            int[] cur = pq.poll();
            int i = cur[0];
            int j = cur[1];
            for (int[] dir : dirs) {
                int row = i + dir[0];
                int col = j + dir[1];
                if (row < 0 || col < 0 || row >= m || col >= n) {
                    continue;
                }
                if (visited[row][col]) {
                    continue;
                }
                visited[row][col] = true;
                res += Math.max(0, cur[2] - heightMap[row][col]);
                pq.offer(new int[]{row, col, Math.max(cur[2], heightMap[row][col])});
            }
        }
        return res;
    }
}