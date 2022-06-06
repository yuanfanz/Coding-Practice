class Solution {
    private int max = 1;
    private boolean[] visited;
    public int maximumDetonation(int[][] bombs) {
        visited = new boolean[bombs.length];
        for (int i = 0; i < bombs.length; ++i) {
            dfs(i, bombs);
            Arrays.fill(visited, false);
        }
        return max;
    }
    
    private int dfs(int i, int[][] bombs) {
        if (visited[i]) {
            return 0;
        }
        visited[i] = true;
        int count = 1;
        for (int j = 0; j < bombs.length; ++j) {
            if (visited[j]) continue;
            if (canBom(bombs[i], bombs[j])) {
                count += dfs(j, bombs);
            }
        }
        max = Math.max(max, count);
        return count;
    }
    
    private boolean canBom(int[] a, int[] b) {
        long x1 = a[0];
        long x2 = b[0];
        long y1 = a[1];
        long y2 = b[1];
        long r = a[2];
        return (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1) <= r * r;
    }
}