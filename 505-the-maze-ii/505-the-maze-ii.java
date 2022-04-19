class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        if (start[0] == destination[0] && start[1] == destination[1]) return 0;
        
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        queue.offer(new int[]{start[0], start[1], 0});
        int[][] visited = new int[m][n];
        for (int[] cur : visited) {
            Arrays.fill(cur, Integer.MAX_VALUE);
        }
        while (queue.size() > 0) {
            int[] cur = queue.poll();
            int i = cur[0];
            int j = cur[1];
            int count = cur[2];
            if (i == destination[0] && j == destination[1]) {
                return count;
            }
            if (count >= visited[i][j]) continue;
            visited[i][j] = count;
            for (int[] dir : dirs) {
                int row = i;
                int col = j;
                int curCount = 0;
                while (row >= 0 && col >= 0 && row < m && col < n && maze[row][col] == 0) {
                    row += dir[0];
                    col += dir[1];
                    curCount++;
                }
                row -= dir[0];
                col -= dir[1];
                curCount--;
                queue.offer(new int[]{row, col, count + curCount});
            }
        }
        return -1;
    }
}