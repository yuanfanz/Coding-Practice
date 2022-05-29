class Solution {
    public int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

        int[][] visited = new int[m][n];
        for (int[] cur : visited) {
            Arrays.fill(cur, -1);
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{0, 0, 0});
        int min = Integer.MAX_VALUE;
        while (pq.size() > 0) {
            int[] cur = pq.poll();
            int i = cur[0];
            int j = cur[1];
            
            if (i == m - 1 && j == n - 1) {
                return cur[2];
            }
            
            if (visited[i][j] != -1 && cur[2] >= visited[i][j]) continue;
            visited[i][j] = cur[2];
            
            for (int[] dir : dirs) {
                int row = i + dir[0];
                int col = j + dir[1];
                int step = cur[2];
                if (row < 0 || col < 0 || row >= m || col >= n) {
                    continue;
                }
                if (grid[row][col] == 1) {
                    step++;
                }
                pq.offer(new int[]{row, col, step});
            }
        }
        return 0;
        
    }
    
}