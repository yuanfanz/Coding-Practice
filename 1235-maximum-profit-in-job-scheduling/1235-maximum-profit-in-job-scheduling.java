class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Job[] arr = new Job[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = new Job(startTime[i], endTime[i], profit[i]);
        }
        Arrays.sort(arr, (a, b) -> a.end - b.end);
        int[] dp = new int[n];
        for (int i = 0; i < n; ++i) {
            dp[i] = arr[i].val;
        }
        for (int i = 1; i < n; ++i) {
            dp[i] = Math.max(dp[i - 1], arr[i].val);
            for (int j = i - 1; j >= 0; --j) {
                if (arr[j].end <= arr[i].start) {
                    dp[i] = Math.max(dp[i], dp[j] + arr[i].val);
                    break;
                }
            }
        }
        return dp[n - 1];
    }
    
    class Job{
        int start;
        int end;
        int val;
        public Job(int start, int end, int val) {
            this.start = start;
            this.end = end;
            this.val = val;
        }
    }
}