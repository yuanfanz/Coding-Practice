class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        
        int m = heights.length; 
        int n = heights[0].length;
        int[][] dirs = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        Queue<int[]> upQueue = new LinkedList<>();
        Queue<int[]> downQueue = new LinkedList<>();
        
        for (int j = 0; j < n; ++j) {
            upQueue.offer(new int[]{0, j});
            downQueue.offer(new int[]{m - 1, j});
            pacific[0][j] = true;
            atlantic[m - 1][j] = true;
        }
        for (int i = 0; i < m; ++i) {
            upQueue.offer(new int[]{i, 0});
            downQueue.offer(new int[]{i, n - 1});
            pacific[i][0] = true;
            atlantic[i][n - 1] = true;
        }
        bfs(upQueue, pacific, heights, dirs);
        bfs(downQueue, atlantic, heights, dirs);
        
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(new ArrayList<>(Arrays.asList(i, j)));
                }
            }
        }
        return result;
    }
    private void bfs(Queue<int[]> queue, boolean[][] visited, int[][] heights, int[][] dirs) {
        while (queue.size() != 0) {
            int[] cur = queue.poll();
            for (int[] dir : dirs) {
                int row = cur[0] + dir[0];
                int col = cur[1] + dir[1];
                if (row < 0 || col < 0 || row >= heights.length || col >= heights[0].length) {
                    continue;
                }
                if (visited[row][col] || heights[row][col] < heights[cur[0]][cur[1]]) {
                    continue;
                }
                visited[row][col] = true;
                queue.offer(new int[]{row, col});
            }
        }
    }
}