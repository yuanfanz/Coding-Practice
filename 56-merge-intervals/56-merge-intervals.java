class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        int[] prevInterval = intervals[0];
        List<int[]> list = new ArrayList<>();
        list.add(prevInterval);
        for (int i = 1; i < intervals.length; ++i) {
            int[] cur = intervals[i];
            if (cur[0] <= prevInterval[1]) {
                prevInterval[1] = Math.max(prevInterval[1], cur[1]);
            } else {
                prevInterval = cur;
                list.add(prevInterval);
            }
        }
        return list.stream().toArray(int[][]::new);
    }
}