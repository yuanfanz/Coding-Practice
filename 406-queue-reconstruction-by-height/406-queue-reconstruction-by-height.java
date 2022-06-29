class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] - b[0]);
        
        int n = people.length;
        int[][] result = new int[n][2];
        for (int[] cur : result) {
            cur[0] = -1;
            cur[0] = -1;
        }
        for (int i = 0; i < n; ++i) {
            int[] cur = people[i];
            
            // System.out.print(cur[0] + " " + cur[1] + " ");
            int front = cur[1];
            int j = 0;
            while (j < n) {
                if (result[j][0] == -1 || result[j][0] >= cur[0]) {
                    if (front == 0) break;
                    front--;
                }
                j++;
            }
            // if (j < n) {
                result[j] = cur;
            // }
        }
        return result;
    }
    
    private void print(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; ++i) {
            System.out.print("[");
            for (int j = 0; j < n; ++j) {
                System.out.print("" + grid[i][j] + " ");
            }
            System.out.print("] ");
        }
        System.out.println();
    }
}