class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        
        int count = 0;
        int prev = intervals[0][1];
        for (int i = 1; i < intervals.length; ++i) {
            if (intervals[i][1] <= prev) {
                count++;
            }
            prev = Math.max(prev, intervals[i][1]);
        }
        return intervals.length - count;
    }
}