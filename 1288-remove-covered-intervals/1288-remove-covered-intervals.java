class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        int count = 1;
        int prevStart = intervals[0][0];
        int prevEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; ++i) {
            if (prevStart < intervals[i][0] && prevEnd < intervals[i][1]) {
                prevStart = intervals[i][0];
                count++;
            }
            prevEnd = Math.max(prevEnd, intervals[i][1]);
        }
        return count;
    }
}