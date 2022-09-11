class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i++]);
        }
        int start = newInterval[0];
        int end = newInterval[1];
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            start = Math.min(start, intervals[i][0]);
            end = Math.max(end, intervals[i++][1]);
        }
        result.add(new int[]{start, end});
        while (i < intervals.length) {
            result.add(intervals[i++]);
        }
        int[][] res = new int[result.size()][2];
        for (int j = 0; j < result.size(); ++j) {
            res[j] = result.get(j);
        }
        return res;
    }
}