class Solution {
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        int n = rooms[0].length;
        
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (rooms[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        while (queue.size() > 0) {
            int[] cur = queue.poll();
            int row = cur[0];
            int col = cur[1];
            for (int[] dir : dirs) {
                int rr = row + dir[0];
                int cc = col + dir[1];
                if (rr < 0 || cc < 0 || rr >= m || cc >= n) continue;
                if (rooms[rr][cc] != Integer.MAX_VALUE) continue;
                rooms[rr][cc] = rooms[row][col] + 1;
                queue.offer(new int[]{rr, cc});
            }
        }
    }
}