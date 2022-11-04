class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        // 创建一个辅助数组，并在首尾各添加1，方便处理边界情况
        int[] tmp = new int[n + 2];
        tmp[0] = 1;
        tmp[n + 1] = 1;
        for (int i = 0; i < n; ++i){
            tmp[i + 1] = nums[i];
        }
        
        int[][] dp = new int[n + 2][n + 2];
        // len 表示开区间长度
        for (int len = 3; len <= n + 2; ++len) {
            // i 表示开区间左端点
            for (int i = 0; i <= n + 2 - len; ++i) {
                int res = 0;
                // k 为开区间内的索引, 枚举 k
                for (int k = i + 1; k < i + len - 1; ++k) {
                    int left = dp[i][k];
                    int right = dp[k][i + len - 1];
                    res = Math.max(res, left + tmp[i] * tmp[k] * tmp[i + len - 1] + right);
                }
                dp[i][i + len - 1] = res;
            }
        }
        return dp[0][n + 1];
    }
}