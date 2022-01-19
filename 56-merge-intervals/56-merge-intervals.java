class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> list = new ArrayList<>();
        
        int[] prev = intervals[0];
        list.add(prev);
        for (int i = 1; i < intervals.length; ++i) {
            int[] cur = intervals[i];
            if (prev[1] >= cur[0]) {
                prev[1] = Math.max(prev[1], cur[1]);
            } else {
                list.add(cur);
                prev = cur;
            }
        }
        int[][] result = new int[list.size()][2];
        int index = 0;
        for (int[] cur : list) {
            result[index++] = cur;
        }
        return result;
    }
}