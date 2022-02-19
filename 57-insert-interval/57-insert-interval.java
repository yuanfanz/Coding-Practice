class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        List<int[]> list = new ArrayList<>();
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            list.add(intervals[i++]);
        }
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i++][1]);
        }
        list.add(newInterval);
        while (i < intervals.length) {
            list.add(intervals[i++]);
        }
        int[][] result = new int[list.size()][2];
        int index = 0;
        for (int[] cur : list) {
            result[index++]= cur;
        }
        return result;
    }
}