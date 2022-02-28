class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        boolean[][] visited = new boolean[image.length][image[0].length];
        dfs(image, dirs, visited, sr, sc, image[sr][sc], newColor);
        return image;
    }
    private void dfs(int[][] image, int[][] dirs, boolean[][] visited, 
                     int sr, int sc, int old, int color) {
        int m = image.length;
        int n = image[0].length;
        if (sr < 0 || sc < 0 || sr >= m || sc >= n) {
            return;
        }
        if (visited[sr][sc] || image[sr][sc] != old) return;
        visited[sr][sc] = true;
        image[sr][sc] = color;
        for (int[] dir : dirs) {
            dfs(image, dirs, visited, sr + dir[0], sc + dir[1], old, color);
        }
    }
}