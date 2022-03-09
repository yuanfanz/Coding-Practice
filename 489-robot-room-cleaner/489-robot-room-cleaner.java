class Solution {
    public void cleanRoom(Robot robot) {
        int[][] dirs = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
        Set<String> set = new HashSet<>();
        dfs(set, dirs, robot, 0, 0, 0);
    }
    private void dfs(Set<String> set, int[][] dirs, Robot robot, int turn, int i, int j) {
        set.add(i + "->" + j);
        robot.clean();
        for (int cur = turn; cur < turn + 4; ++cur) {
            int row = i + dirs[cur % 4][0];
            int col = j + dirs[cur % 4][1];
            String next = row + "->" + col;
            if (!set.contains(next) && robot.move()) {
                dfs(set, dirs, robot, cur % 4, row, col);
            }
            robot.turnRight();
        }
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
}