class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{0, 0, 0});
        int[][] visited = new int[m][n];
        for (int[] cur : visited) {
            Arrays.fill(cur, Integer.MAX_VALUE);
        }
        while (pq.size() > 0) {
            int[] cur = pq.poll();
            int i = cur[0];
            int j = cur[1];
            int cost = cur[2];
            if (i == m - 1 && j == n - 1) return cost;
            
            if (cost >= visited[i][j]) continue;
            visited[i][j] = cost;
            
            for (int k = 0; k < 4; ++k) {
                int nextCost = cost;
                int row = i + dirs[k][0];
                int col = j + dirs[k][1];
                if (row < 0 || col < 0 || row >= m || col >= n) continue;
                if (grid[i][j] != k + 1) {
                    nextCost++;
                }
                pq.offer(new int[]{row, col, nextCost});
            }
        }
        return 0;
    }
}