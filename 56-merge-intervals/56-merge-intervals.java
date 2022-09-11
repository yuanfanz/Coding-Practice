class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        int[] prev = intervals[0];
        list.add(prev);
        for (int i = 1; i < intervals.length; ++i) {
            int[] cur = intervals[i];
            if (cur[0] <= prev[1]) {
                prev[1] = Math.max(prev[1], cur[1]);
            } else {
                prev = cur;
                list.add(intervals[i]);
            }
        }
        int[][] result = new int[list.size()][2];
        for (int i = 0; i < list.size(); ++i) {
            result[i] = list.get(i);
        }
        return result;
    }
}