class Solution {
    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        List<List<Integer>> result = new ArrayList<>();
        
        List<int[]> list = new ArrayList<>();
        
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start[0], start[1], 0});
        boolean[][] visited = new boolean[m][n];
        
        while (queue.size() != 0) {
            int[] cur = queue.poll();
            if (visited[cur[0]][cur[1]]) continue;
            visited[cur[0]][cur[1]] = true;
            int dis = cur[2];
            // only add the coordinates that within the price range
            if (isValid(cur, grid, pricing)) {
                list.add(cur);
            }
            for (int[] dir : dirs) {
                int row = cur[0] + dir[0];
                int col = cur[1] + dir[1];
                if (row < 0 || col < 0 || row >= m || col >= n || grid[row][col] == 0) {
                    continue;
                }
                queue.offer(new int[]{row, col, dis + 1});
            }
        }
        // sort the list by criteria
        Collections.sort(list, new Comparator<>(){
            @Override
            public int compare(int[] a, int[] b) {
                // compare distance
                if (a[2] == b[2]) {
                    // then compare price
                    if (grid[a[0]][a[1]] == grid[b[0]][b[1]]) {
                        // then compare row
                        if (a[0] == b[0]) {
                            // then compare col
                            return a[1] - b[1];
                        } else {
                            return a[0] - b[0];
                        }
                    } else {
                        return grid[a[0]][a[1]] - grid[b[0]][b[1]];
                    }
                } else {
                    return a[2] - b[2];
                }
            }
        });
        for (int i = 0; i < list.size(); ++i) {
            if (result.size() < k) {
                List<Integer> newList = new ArrayList<>();
                newList.add(list.get(i)[0]);
                newList.add(list.get(i)[1]);
                result.add(newList);
            }
        }
        return result;
    }
    private boolean isValid(int[] cur, int[][] grid, int[] pricing) {
        if (grid[cur[0]][cur[1]] <= 1) {
            return false;
        }
        if (grid[cur[0]][cur[1]] > pricing[1] || grid[cur[0]][cur[1]] < pricing[0]) {
            return false;
        }
        return true;
    }
}



