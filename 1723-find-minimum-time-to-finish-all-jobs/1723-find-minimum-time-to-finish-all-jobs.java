class Solution {
    private int res = Integer.MAX_VALUE;
    public int minimumTimeRequired(int[] jobs, int k) {
        int i = 0;
        int j = jobs.length * 10000000;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (dfs(jobs, 0, k, mid, new int[k])) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return j;
    }
    
    private boolean dfs(int[] jobs, int cur, int k, int mid, int[] workers) {
        // whenever reach the end of jobs array
        // it means we tried 1 way of distributing jobs
        if (cur == jobs.length) {
            return true;
        }
        
        int flag = 0;
        for (int i = 0; i < k; ++i) {
            if (workers[i] + jobs[cur] > mid) continue;
            
            // flag means if already assign a job
            if (workers[i] == 0) {
                if (flag == 1) continue;
                flag = 1;
            }
            
            workers[i] += jobs[cur];
            if (dfs(jobs, cur + 1, k, mid, workers)) return true;
            workers[i] -= jobs[cur];
        }
        return false;
    }
}