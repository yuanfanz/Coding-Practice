class Solution {
    public String findShortestWay(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        if (start[0] == destination[0] && start[1] == destination[1]) return "";
        
        int[][] dirs = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
        String[] dirstr = new String[]{"u","r","d","l"};
        Queue<Tuple> queue = new LinkedList<>();
        queue.offer(new Tuple(start[0], start[1], 0, ""));
        Tuple[][] visited = new Tuple[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                visited[i][j] = new Tuple(i, j, Integer.MAX_VALUE, "");
            }
        }
        while (queue.size() > 0) {
            Tuple cur = queue.poll();
            int i = cur.i;
            int j = cur.j;
            int count = cur.count;
            String path = cur.path;
            
            Tuple obj = visited[i][j];
            if (obj.compareTo(cur) <= 0) continue;
            
            visited[i][j] = cur;
            boolean fall = false;
            for (int k = 0; k < dirs.length; ++k) {
                if (fall) continue;
                int[] dir = dirs[k];
                int row = i;
                int col = j;
                int curCount = 0;
                while (row >= 0 && col >= 0 && row < m && col < n && maze[row][col] == 0) {
                    row += dir[0];
                    col += dir[1];
                    curCount++;
                    if (row == destination[0] && col == destination[1]) {
                        fall = true;
                        break;
                    }
                }
                if (!fall) {
                    row -= dir[0];
                    col -= dir[1];
                    curCount--;
                }
                queue.offer(new Tuple(row, col, cur.count + curCount, cur.path + dirstr[k]));
            }
        }
        Tuple res = visited[destination[0]][destination[1]];
        if (res.count == Integer.MAX_VALUE) return "impossible";
        return res.path;
    }
    
    class Tuple implements Comparable<Tuple> {
        int i;
        int j;
        int count;
        String path;
        public Tuple(int i, int j, int count, String path) {
            this.i = i;
            this.j = j;
            this.count = count;
            this.path = path;
        }
        public int compareTo(Tuple tuple) {
            return this.count == tuple.count ? this.path.compareTo(tuple.path) : this.count - tuple.count;
        }
    }
}