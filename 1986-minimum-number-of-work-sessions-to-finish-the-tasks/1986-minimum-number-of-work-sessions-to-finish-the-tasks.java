class Solution {
    public int minSessions(int[] tasks, int sessionTime) {
        int i = 1;
        int j = tasks.length + 1;
        
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (dfs(tasks, 0, sessionTime, mid, new int[mid])) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return j;
    }
    
    private boolean dfs(int[] tasks, int cur, int sessionTime, int mid, int[] workers) {
        if (cur == tasks.length) {
            return true;
        }
        // flag means if already assign a job to a worker that has no work
        boolean flag = false;
        for (int i = 0; i < mid; ++i) {
            // cannot work more than session time
            if (workers[i] + tasks[cur] > sessionTime) continue;
            
            if (workers[i] == 0) {
                // if already assign work to another worker that has no work
                // skip current no work worker
                if (flag) continue;
                flag = true;
            }
            
            workers[i] += tasks[cur];
            if (dfs(tasks, cur + 1, sessionTime, mid, workers)) return true;
            workers[i] -= tasks[cur];
        }
        return false;
    }
}