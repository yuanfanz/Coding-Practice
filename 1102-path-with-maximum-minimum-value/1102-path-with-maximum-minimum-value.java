class Solution {
    public int maximumMinimumPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[2] - a[2]);
        pq.offer(new int[]{0, 0, grid[0][0]});
        int[][] visited = new int[m][n];
        for (int[] cur : visited) {
            Arrays.fill(cur, -1);
        }
        while (pq.size() > 0) {
            int[] cur = pq.poll();
            int i = cur[0];
            int j = cur[1];
            int value = cur[2];
            if (i == m - 1 && j == n - 1) {
                return value;
            }
            if (visited[i][j] >= value) continue;
            visited[i][j] = value;
            for (int[] dir : dirs) {
                int row = i + dir[0];
                int col = j + dir[1];
                if (row < 0 || col < 0 || row >= m || col >= n) continue;
                int nextValue = Math.min(value, grid[row][col]);
                pq.offer(new int[]{row, col, nextValue});
            }
        }
        return -1;
    }
}













