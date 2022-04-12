class Solution {
    public int numSubmat(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        
        int res = 0;
        for (int i = 0; i < m; ++i) {
            int[] nums = new int[n];
            Arrays.fill(nums, 1);
            for (int j = i; j < m; ++j) {
                for (int k = 0; k < n; ++k) {
                    nums[k] &= mat[j][k];
                }
                res += countOneRow(nums);
            }
        }
        return res;
    }
    
    private int countOneRow(int[] nums) {
        int res = 0;
        int cur = 0;
        for (int i = 0; i < nums.length; ++i) {
            cur = nums[i] == 0 ? 0 : cur + 1;
            res += cur;
        }
        return res;
    }
}