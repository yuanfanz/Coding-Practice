class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        int[] prev = intervals[0];
        List<int[]> list = new ArrayList<>();
        list.add(prev);
        int i = 1;
        while (i < intervals.length) {
            if (prev[1] >= intervals[i][0]) {
                prev[1] = Math.max(prev[1], intervals[i][1]);
            } else {
                prev = intervals[i];
                list.add(intervals[i]);
            }
            i++;
        }
        return list.stream().toArray(int[][]::new);
    }
}