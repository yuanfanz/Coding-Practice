class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[] nums = new int[m];
        for (int i = 0; i < m; ++i) {
            nums[i] = grid[i][0];
        }
        int leftBound = findLeftBound(nums);
        int count = 0;
        // System.out.println(leftBound);
        // System.out.println(m);
        if (leftBound >= 0) {
            count += (m - leftBound) * n;
        }
        if (leftBound == -1) {
            leftBound = m;
        }
        for (int i = 0; i < leftBound; ++i) {
            int[] row = grid[i];
            int curLeft = findLeftBound(row);
            if (curLeft == -1) continue;
            count += n - curLeft;
        }
        return count;
    }
    
    private int findLeftBound(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] < 0) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        if (i > nums.length - 1 || nums[i] >= 0) {
            i = -1;
        }
        return i;
    }
}