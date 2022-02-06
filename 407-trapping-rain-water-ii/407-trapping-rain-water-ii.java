class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;
        
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        boolean[][] visited = new boolean[m][n];
        
        for (int i = 0; i < m; ++i) {
            pq.offer(new int[]{i, 0, heightMap[i][0]});
            pq.offer(new int[]{i, n - 1, heightMap[i][n - 1]});
            visited[i][0] = true;
            visited[i][n - 1] = true;
        }
        for (int j = 1; j < n - 1; ++j) {
            pq.offer(new int[]{0, j, heightMap[0][j]});
            pq.offer(new int[]{m - 1, j, heightMap[m - 1][j]});
            visited[0][j] = true;
            visited[m - 1][j] = true;
        }
        int total = 0;
        while (pq.size() != 0) {
            int[] cell = pq.poll();
            for (int[] dir : dirs) {
                int i = cell[0] + dir[0];
                int j = cell[1] + dir[1];
                if (i < 0 || j < 0 || i >= m || j >= n || visited[i][j]) {
                    continue;
                }
                visited[i][j] = true;
                total += Math.max(0, cell[2] - heightMap[i][j]);
                pq.offer(new int[]{i, j, Math.max(cell[2], heightMap[i][j])});
            }
        }
        return total;
    }
}