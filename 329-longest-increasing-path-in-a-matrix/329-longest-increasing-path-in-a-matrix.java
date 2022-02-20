class Solution {
    public int longestIncreasingPath(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

        boolean[][] visited = new boolean[m][n];
        int[][] indegree = new int[m][n];
        Map<String, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                for (int[] dir : dirs) {
                    int row = i + dir[0];
                    int col = j + dir[1];
                    if (row < 0 || col < 0 || row >= m || col >= n) {
                        continue;
                    }
                    if (board[row][col] <= board[i][j]) {
                        continue;
                    }
                    String key = i + "->" + j;
                    List<int[]> list = map.getOrDefault(key, new ArrayList<>());
                    list.add(new int[]{row, col});
                    map.put(key, list);
                    indegree[row][col]++;
                }
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (indegree[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        int step = 0;
        while (queue.size() > 0) {
            int size = queue.size();
            for (int k = 0; k < size; ++k) {
                int[] cur = queue.poll();
                String key = cur[0] + "->" + cur[1];
                if (map.containsKey(key)) {
                    List<int[]> list = map.get(key);
                    for (int[] next : list) {
                        int row = next[0];
                        int col = next[1];
                        indegree[row][col]--;
                        if (indegree[row][col] == 0) {
                            queue.offer(new int[]{row, col});
                        }
                    }
                }
            }
            step++;
        }
        return step;
    }
}
















