class Solution {
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        int n = rooms[0].length;
        
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (rooms[i][j] == 0) {
                    queue.offer(new int[]{i, j, 0});
                }
            }
        }
        while (queue.size() > 0) {
            int[] cur = queue.poll();
            int row = cur[0];
            int col = cur[1];
            int dis = cur[2];
            rooms[row][col] = Math.min(rooms[row][col], dis);
            for (int[] dir : dirs) {
                int rr = row + dir[0];
                int cc = col + dir[1];
                if (rr < 0 || cc < 0 || rr >= m || cc >= n) continue;
                if (rooms[rr][cc] != Integer.MAX_VALUE) continue;
                queue.offer(new int[]{rr, cc, dis + 1});
            }
        }
    }
}