class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        if (start[0] == destination[0] && start[1] == destination[1]) return true;
        
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start[0], start[1]});
        boolean[][] visited = new boolean[m][n];
        visited[start[0]][start[1]] = true;
        while (queue.size() > 0) {
            int[] cur = queue.poll();
            int i = cur[0];
            int j = cur[1];
            if (i == destination[0] && j == destination[1]) return true;
            for (int[] dir : dirs) {
                int row = i;
                int col = j;
                while (row >= 0 && col >= 0 && row < m && col < n && maze[row][col] == 0) {
                    row += dir[0];
                    col += dir[1];
                }
                row -= dir[0];
                col -= dir[1];
                if (visited[row][col]) continue;
                visited[row][col] = true;
                queue.offer(new int[]{row, col});
            }
        }
        return false;
    }
}