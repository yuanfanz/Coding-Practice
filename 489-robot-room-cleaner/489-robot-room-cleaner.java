

class Solution {
    public void cleanRoom(Robot robot) {
        int[][] dirs = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
        dfs(robot, dirs, 0, 0, 0, new HashSet<>());
    }
    private void dfs(Robot robot, int[][] dirs, int i, int j, int direction, Set<String> set) {
        robot.clean();
        set.add(i + "->" + j);
        
        for (int cur = direction; cur < direction + 4; ++cur) {
            int row = i + dirs[cur % 4][0];
            int col = j + dirs[cur % 4][1];
            String next = row + "->" + col;
            if (!set.contains(next) && robot.move()) {
                dfs(robot, dirs, row, col, cur % 4, set);
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