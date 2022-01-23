class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        
        int m = heights.length;
        int n = heights[0].length;
        int[][] dirs = new int[][]{{0,-1},{-1,0},{0,1},{1,0}};
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                boolean pacific = false;
                boolean atlantic = false;
                if (dfs(dirs, i, j, new boolean[m][n], m, n, result, heights, Integer.MAX_VALUE, "pacific")) {
                    pacific = true;
                }
                if (dfs(dirs, i, j, new boolean[m][n], m, n, result, heights, Integer.MAX_VALUE, "atlantic")) {
                    atlantic = true;
                }
                if (pacific && atlantic) {
                    result.add(new ArrayList<>(Arrays.asList(i, j)));
                }
            }
        }
        return result;
    }
    private boolean dfs(int[][] dirs, int i, int j, boolean[][] visited, int m, int n,
                    List<List<Integer>> result, int[][] heights, int height, String ocean) {
        if ((i < 0 || j < 0) && ocean.equals("pacific")) {
            return true;
        }
        if ((i >= m || j >= n) && ocean.equals("atlantic")) {
            return true;
        }
        if ((i < 0 || j < 0) || (i >= m || j >= n)) {
            return false;
        }
        if (!visited[i][j] && heights[i][j] <= height) {
            visited[i][j] = true;
            for (int[] dir : dirs) {
                int row = i + dir[0];
                int col = j + dir[1];
                if (dfs(dirs, row, col, visited, m, n, result, heights, heights[i][j], ocean)) {
                    return true;
                }
            }
        }
        return false;
    }
}