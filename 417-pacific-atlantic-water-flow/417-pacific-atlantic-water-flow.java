class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        
        int m = heights.length;
        int n = heights[0].length;
            
        int[][] ocean = new int[m][n];
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        for (int j = 0; j < n; ++j) {
            ocean[0][j]++;
            visited[0][j] = true;
            queue.offer(new int[]{0, j});
        }
        for (int i = 1; i < m; ++i) {
            ocean[i][0]++;
            visited[i][0] = true;
            queue.offer(new int[]{i, 0});
        }
        // pacific BFS
        bfs(queue, dirs, heights, visited, ocean);
        visited = new boolean[m][n];
        for (int j = 0; j < n; ++j) {
            ocean[m - 1][j]++;
            visited[m - 1][j] = true;
            queue.offer(new int[]{m - 1, j});
        }
        for (int i = 0; i < m - 1; ++i) {
            ocean[i][n - 1]++;
            visited[i][n - 1] = true;
            queue.offer(new int[]{i, n - 1});
        }
        // atlantic BFS
        bfs(queue, dirs, heights, visited, ocean);
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (ocean[i][j] == 2) {
                    result.add(new ArrayList<>(Arrays.asList(i, j)));
                }
            }
        }
        return result;
    }
    private void bfs(Queue<int[]> queue, int[][] dirs, int[][] heights, 
                     boolean[][] visited, int[][] ocean) {
        int m = heights.length;
        int n = heights[0].length;
        while (queue.size() != 0) {
            int[] cur = queue.poll();
            for (int[] dir : dirs) {
                int row = cur[0] + dir[0];
                int col = cur[1] + dir[1];
                if (row < 0 || col < 0 || row >= m || col >= n
                   || visited[row][col]) {
                    continue;
                }
                if (heights[row][col] < heights[cur[0]][cur[1]]) {
                    continue;
                }
                visited[row][col] = true;
                ocean[row][col]++;
                queue.offer(new int[]{row, col});
            }
        }
    }
}