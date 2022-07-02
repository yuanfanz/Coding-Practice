class Solution {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{0, 0, 0, 0});
        int[][][] visited = new int[m][n][k + 1];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                Arrays.fill(visited[i][j], Integer.MAX_VALUE);
            }
        }
        while (pq.size() > 0) {
            int[] cur = pq.poll();
            int i = cur[0];
            int j = cur[1];
            int step = cur[2];
            int curK = cur[3];
            if (i == m - 1 && j == n - 1) {
                return step;
            }
            if (visited[i][j][curK] <= step) continue;
            visited[i][j][curK] = step;
            for (int[] dir : dirs) {
                int row = i + dir[0];
                int col = j + dir[1];
                if (row < 0 || col < 0 || row >= m || col >= n) continue;
                int nextK = curK;
                if (grid[row][col] == 1) {
                    nextK++;
                }
                if (nextK > k) continue;
                pq.offer(new int[]{row, col, step + 1, nextK});
            }
        }
        return -1;
    }
}















