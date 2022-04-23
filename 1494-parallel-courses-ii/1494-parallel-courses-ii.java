class Solution {
    public int minNumberOfSemesters(int n, int[][] relations, int k) {
        int[] pre = new int[n];// 前置课程 二进制状态压缩
        for (int[] relation : relations) {
            pre[relation[1] - 1] |= 1 << relation[0] - 1;
        }
        // dp[mask]表示修完mask中所有课程的最小学期数
        int[] dp = new int[1 << n];
        Arrays.fill(dp, n);// 题目保证能全部修完，初始化最大值n即可
        dp[0] = 0;// 假设为4门课程，初始0门课需要0学期 dp[0000] = 0，最终目标是求 dp[1111]
        for (int mask = 0; mask < 1 << n; ++mask) {// 当前状态
            int canStudy = 0;// 当前状态下可学习的课程
            for (int i = 0; i < n; ++i) {
                if ((mask & 1 << i) != 0) continue;// 已经学过的不管
                // 包含所有的前置课程，则可以学习
                if ((mask & pre[i]) == pre[i]) canStudy |= 1 << i;
            }
            /* 枚举可学习课程的子集进行状态转移，这个枚举方式可以特别记忆一下
               例如 1010 子集为 1010 1000 0010
               首先它们一定在 (0000, 1010] 范围内，过程如下
               第一个 1010
               第二个 (1010 - 1) & 1010 = 1001 & 1010 = 1000
               第三个 (1000 - 1) & 1010 = 0111 & 1010 = 0010
               第四个 (0010 - 1) & 1010 = 0001 & 1010 = 0000 不合法
            */
            for (int study = canStudy; study > 0; study = study - 1 & canStudy) {
                if (Integer.bitCount(study) > k) continue;
                dp[mask | study] = Math.min(dp[mask | study], dp[mask] + 1);
            }
        }
        return dp[(1 << n) - 1];
    }
}