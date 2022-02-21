
class Solution {
    public void cleanRoom(Robot robot) {
        int[][] dirs = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
        
        Set<String> set = new HashSet<>();
        dfs(robot, dirs, set, 0, 0, 0);
    }
    private void dfs(Robot robot, int[][] dirs, Set<String> set, int i, int j, int turn) {
        String str = i + "->" + j;
        if (set.contains(str)) return;
        set.add(str);
        robot.clean();
        for (int cur = turn; cur < turn + 4; ++cur) {
            int row = i + dirs[cur % 4][0];
            int col = j + dirs[cur % 4][1];
            String next = row + "->" + col;
            if (!set.contains(next) && robot.move()) {
                dfs(robot, dirs, set, row, col, cur % 4);
            }
            robot.turnLeft();
        }
        robot.turnLeft();
        robot.turnLeft();
        robot.move();
        robot.turnLeft();
        robot.turnLeft();
    }
}

/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */
