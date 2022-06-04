class Solution {
    public int minKnightMoves(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        int count = 0;
        x = Math.abs(x);
        y = Math.abs(y);
        int[][] up = new int[][]{{-2,1},{-1,2},{2,1},{1,2}};
        int[][] down = new int[][]{{-2,-1},{-1,-2},{1,-2},{2,-1}};
        int[][] ori = new int[][]{{-2,1},{-1,2},{2,1},{1,2},
                                   {-2,-1},{-1,-2},{1,-2},{2,-1}};
        Set<String> set = new HashSet<>();
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                int[] cur = queue.poll();
                String s = cur[0] + "," + cur[1];
                if (set.contains(s)) continue;
                set.add(s);
                if (cur[0] == x && cur[1] == y) {
                    return count;
                }
                int[][] dirs = ori;
                if (x > cur[0] && y > cur[1]) {
                    dirs = up;
                } else if (x < cur[0] && y < cur[1]) {
                    dirs = down;
                }
                for (int[] dir : dirs) {
                    int row = cur[0] + dir[0];
                    int col = cur[1] + dir[1];
                    if (row < -1 || col < -1) continue;
                    queue.offer(new int[]{row, col});
                }
            }
            count++;
        }
        return -1;
    }
}