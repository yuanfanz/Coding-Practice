class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        List<int[]> list = new ArrayList<>();
        
        int[] prev = intervals[0];
        list.add(prev);
        for (int i = 1; i < intervals.length; ++i) {
            int[] cur = intervals[i];
            if (prev[1] <= cur[0]) {
                prev = cur;
                list.add(cur);
            }
        }
        return intervals.length - list.size();
    }
}