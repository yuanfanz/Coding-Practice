class Solution {
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        int n = rooms[0].length;
        
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (rooms[i][j] == 0) {
                    boolean[][] visited = new boolean[m][n];
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j, 1});
                    while (queue.size() != 0) {
                        int[] cur = queue.poll();
                        int dis = cur[2];
                        for (int[] dir : dirs) {
                            int row = cur[0] + dir[0];
                            int col = cur[1] + dir[1];
                            if (row < 0 || col < 0 || row >= m || col >= n
                               || rooms[row][col] <= 0 || visited[row][col]) {
                                continue;
                            }
                            visited[row][col] = true;
                            rooms[row][col] = Math.min(rooms[row][col], dis);
                            queue.offer(new int[]{row, col, dis + 1});
                        }
                    }
                }
            }
        }
    }
}