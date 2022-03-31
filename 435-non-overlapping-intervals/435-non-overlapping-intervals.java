class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        
        int count = 1;
        int prev = intervals[0][1];
        for (int[] cur : intervals) {
            if (prev <= cur[0]) {
                prev = cur[1];
                count++;
            }
        }
        return intervals.length - count;
    }
}